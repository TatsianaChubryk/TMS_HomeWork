package com.example.homework

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import android.util.Log.i as Log

/*Timer с сохранением состояния при повороте экрана (использовать ViewModel и LiveData)*/

class MainActivity : AppCompatActivity() {

    private lateinit var etSecond: EditText
    private lateinit var btnStart: Button
    private lateinit var tvTimer: TextView

    private val timer by lazy {
        ViewModelProvider(this)[TimerViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

    }

/*   override fun onCreateView(
             inflater: LayoutInflater, container: ViewGroup?,
             savedInstanceState: Bundle?
     ): View {
         _binding = FragmentDz20Binding.inflate(inflater, container, false)
         return binding.root
     }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //super.onViewCreated(view, savedInstanceState)


        btnStart.setOnClickListener {
            val second = if (etSecond.text.toString() != "")
                etSecond.text.toString().toLong()
            else
                0
            timer.startTimer(second)
            // second = etSecond.text.toString().toLong()
           // setTvSeconds()
        }
    }

 /*   private fun setTvSeconds() {
        timer.liveData.observe(viewLifecycleOwner, {
            tvTimer.text = it
        })
    }*/

    override fun onDestroyView() {
        //super.onDestroyView()
        tvTimer.text = null
    }

    private fun initView() {
        etSecond = findViewById(R.id.etSecond)
        btnStart = findViewById(R.id.btnStart)
        tvTimer = findViewById(R.id.tvTimer)
    }
}