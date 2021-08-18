package com.example.homework.hw.homework.lesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.homework.R

/*
Создать функциональную переменную для выражение макс(а*б*с, а+б+с)
*/

class TaskTwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_two)

        val btnResult: Button = findViewById(R.id.btn_result)
        val etA:EditText = findViewById(R.id.et_a)
        val etB:EditText = findViewById(R.id.et_b)
        val etC:EditText = findViewById(R.id.et_c)
        btnResult.setOnClickListener {
            val a = etA.text.toString().toInt()
            val b = etB.text.toString().toInt()
            val c = etC.text.toString().toInt()
            val max: (Int, Int, Int) -> Int = { a, b, c ->
                val left = a * b * c
                val right = a + b + c
                val result = if (left > right)
                    left
                else
                    right
                result
            }

            val tvResult:TextView = findViewById(R.id.tv_result)
            tvResult.text = max(a, b, c).toString()
        }
    }
}