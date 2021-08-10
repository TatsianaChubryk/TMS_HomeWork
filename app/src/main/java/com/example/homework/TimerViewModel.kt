package com.example.homework

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimerViewModel: ViewModel() {

    val liveData = MutableLiveData<String>()

    fun startTimer(second: Long) {
        object : CountDownTimer(second * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val timer = (millisUntilFinished / 1000).toString()
                liveData.value = timer
            }

            override fun onFinish() {
                val timer = "DONE"
                liveData.value = timer
            }
        }.start()
    }
}