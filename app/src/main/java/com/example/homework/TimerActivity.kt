package com.example.homework

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimerActivity : ViewModel() {

    val liveData = MutableLiveData<String>()
    val isFinishLD = MutableLiveData<Boolean>()

    fun startTimer(seconds: Long) {
        object : CountDownTimer(seconds * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val s = "seconds: " + millisUntilFinished / 1000
                liveData.value = s
            }

            override fun onFinish() {
                isFinishLD.value = true
           }
        }.start()
    }
}