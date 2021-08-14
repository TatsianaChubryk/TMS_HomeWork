package com.example.homework.hw.homework.lesson21

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import com.example.homework.R
import com.example.homework.databinding.MediaPlayerFragmentBinding
import java.lang.Exception

class MediaPlayerFragment : Fragment(), View.OnClickListener {

    private var _binding: MediaPlayerFragmentBinding? = null
    private val binding get() = _binding
    private var mp: MediaPlayer? = null
    private var currentSong: MutableList<Int> = mutableListOf(R.raw.music)

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
        binding?.btnPlay?.setOnClickListener(this)
        soundControl(currentSong[0])
    }

    private fun soundControl(id: Int) {
        binding?.btnPlay?.setOnClickListener {
            if (mp == null) {
                mp = MediaPlayer.create(context, id)

                initSeekBar()
            }
            mp?.start()
        }

        binding?.btnPause?.setOnClickListener {
            if (mp != null) {
                mp?.pause()
            }
        }

        binding?.btnStop?.setOnClickListener {
            if (mp != null) {
                mp?.stop()
                mp?.reset()
                mp?.release()
                mp = null
            }
        }

        binding?.seekbar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) mp?.seekTo(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
    }

    private fun initSeekBar() {
        binding?.seekbar?.max = mp!!.duration

        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                try {
                    binding?.seekbar?.progress = mp!!.currentPosition
                    handler.postDelayed(this, 1000)
                } catch (e: Exception) {
                    binding?.seekbar?.progress = 0
                }
            }
        }, 0)
    }

    override fun onClick(v: View?) {

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}