package com.example.homework

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/*Посчитайте сумму всех чисел от 1 до 100*/

class TaskThreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_three)

        val tvSum: TextView = findViewById(R.id.tv_sum)

        val number = 100
        val sum = number * (number + 1) / 2
        tvSum.text = sum.toString()
    }

}


