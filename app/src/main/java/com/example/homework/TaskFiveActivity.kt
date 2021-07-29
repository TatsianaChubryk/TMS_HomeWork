package com.example.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

/*
Найти сумму четных чисел и их количество в диапазоне от 1 до 99
*/

class TaskFiveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_five)

        val tvSum:TextView = findViewById(R.id.tv_sum)
        val tvAmount:TextView = findViewById(R.id.tv_amount)

        var sum = 0
        var amount = 0
            for (i in 1..99) {
                if (i % 2 == 0) {
                    sum += i
                    amount++
            }
        }
        tvSum.text = ("Сумма четных чисел [0..99] = $sum")
        tvAmount.text = ("Кол-во четных чисел [0..99] = $amount")
    }
}