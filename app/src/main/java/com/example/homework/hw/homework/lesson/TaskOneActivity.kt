package com.example.homework.hw.homework.lesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.homework.R

/*
Если а – четное посчитать а*б, иначе а+б используя when
*/

class TaskOneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_one)

        val btnResult:Button = findViewById(R.id.btn_result)
        val etA:EditText = findViewById(R.id.et_a)
        val etB:EditText = findViewById(R.id.et_b)
        btnResult.setOnClickListener {
            val a = etA.text.toString().toInt()
            val b = etB.text.toString().toInt()
            val result = when (a % 2) {
                0 -> a * b
                else -> a + b
            }
            val tvResult:TextView = findViewById(R.id.tv_result)
            tvResult.text = result.toString()
        }
    }
}