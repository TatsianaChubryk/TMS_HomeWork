package com.example.homework.hw.homework.lesson21

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework.R
import com.example.homework.databinding.MediaPlayerFragmentBinding

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        binding?.btnPlay?.setOnClickListener(this)
        soundControl(currentSong[0])
    }

    private fun soundControl(id: Int){
        binding?.btnPlay?.setOnClickListener {
            if (mp == null) {
                mp = MediaPlayer.create(this, id)
                Log.d("MainActivity", "ID: ${mp!!.audioSessionId}")

            }
            mp?.start()
            Log.d("MainActivity", "Duration: ${mp!!.audioSessionId}")
        }
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null

    }
}