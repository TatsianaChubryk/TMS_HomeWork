package com.example.homework

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import java.util.*

/*
Создать программу, которая будет проверять попало ли случайно выбранное из отрезка [5;155]
целое число в интервал [25;100] и сообщать результат на экран.
*/

class TaskOneActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_one)

        val tvRandNumber:TextView = findViewById(R.id.tv_randNumber)
        val btnRand:Button = findViewById(R.id.btn_rand)
        val tvResult:TextView = findViewById(R.id.tv_result)

        btnRand.setOnClickListener {
            val numberInterval = 25..100
            val randOfTo = 5..155
            val randomNumber = randOfTo.random()
            tvRandNumber.text = randomNumber.toString()

            if (randomNumber in numberInterval)
                tvResult.text = "Рандомное число $randomNumber попало в интервал [25;100]"
            else
                tvResult.text = "Рандомное число $randomNumber не попало в интервал [25;100]"
        }

    }
}