package com.example.homework

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


/*обратный отсчет (таймер)*/

class MainActivity : AppCompatActivity() {
    private lateinit var etSecond: EditText
    private lateinit var btnStart: Button
    private lateinit var tvTimer: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

        btnStart.setOnClickListener{
            timer(second = etSecond.text.toString().toLong())
        }
    }

    private fun timer(second: Long){
        object : CountDownTimer(second * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                tvTimer.text = (millisUntilFinished / 1000).toString()
            }
            override fun onFinish() {
                tvTimer.text = getString(R.string.done)
            }
        }.start()
    }

    private fun initView(){
        etSecond = findViewById(R.id.etSecond)
        btnStart = findViewById(R.id.btnStart)
        tvTimer = findViewById(R.id.tvTimer)
    }
}