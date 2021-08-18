package com.example.homework.hw.homework.lesson21

import android.content.ComponentName
import android.content.Context.BIND_AUTO_CREATE
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import com.example.homework.databinding.MediaPlayerFragmentBinding
import java.lang.Exception

class MediaPlayerFragment : Fragment() {

    private var _binding: MediaPlayerFragmentBinding? = null
    private val binding get() = _binding

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            isBinded = true
            val binder = service as MediaPlayerService.LocalBinder
            myService = binder.getAudioPlayerServiceInstance()
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            isBinded = false
            myService = null
        }
    }

        var isBinded: Boolean = false
        var myService: MediaPlayerService? = null

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            _binding = MediaPlayerFragmentBinding.inflate(inflater, container, false)
            return binding?.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            val intent = Intent(context, MediaPlayerService::class.java)
            activity?.bindService(intent, connection, BIND_AUTO_CREATE)

            binding?.btnPlay?.setOnClickListener {
                if (isBinded) {
                    myService?.playMusic()
                    initSeekBar()
                }
            }

            binding?.btnPause?.setOnClickListener {
                if (isBinded) {
                    myService?.pauseMusic()
                }
            }

            binding?.btnStop?.setOnClickListener {
                if (isBinded) {
                    myService?.stopMusic()
                }
            }
            binding?.seekbar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    if (fromUser) myService?.mp?.seekTo(progress)
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {

                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {

                }
            })

         }

    private fun initSeekBar() {
        binding?.seekbar?.max = myService?.mp!!.duration

        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                try {
                    binding?.seekbar?.progress = myService?.mp!!.currentPosition
                    handler.postDelayed(this,1000)
                } catch (e: Exception) {
                    binding?.seekbar?.progress = 0
                }
            }
        }, 0)
    }

      override fun onDestroy() {
          super.onDestroy()
          _binding = null
           if (isBinded) {
               activity?.unbindService(connection)
               isBinded = false
           }
      }
}