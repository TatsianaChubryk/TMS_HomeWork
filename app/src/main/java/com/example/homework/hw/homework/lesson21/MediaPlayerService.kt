package com.example.homework.hw.homework.lesson21

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import com.example.homework.R

class MediaPlayerService() : Service() {

    var mp: MediaPlayer? = null
    private val binder: IBinder = LocalBinder()

    override fun onBind(intent: Intent): IBinder? {
        return binder
    }

    override fun onCreate() {
        super.onCreate()
        mp = MediaPlayer.create(this, R.raw.music)
    }

    fun playMusic() {
        mp?.start()
    }

    fun pauseMusic() {
        mp?.pause()
    }

    fun stopMusic() {
        mp?.apply{
            pause()
            seekTo(0)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mp?.stop()
        mp?.release()
    }

    inner class LocalBinder: Binder(){
        fun getAudioPlayerServiceInstance(): MediaPlayerService {
            return this@MediaPlayerService
        }
    }
}