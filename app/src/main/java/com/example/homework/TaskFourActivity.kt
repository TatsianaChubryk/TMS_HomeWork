package com.example.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

/*
Есть два конверта со сторонами (а,б) и (в,г) определить, можно ли один конверт вложить в другой
*/

class TaskFourActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_four)

        val edA:EditText = findViewById(R.id.ed_a)
        val edB:EditText = findViewById(R.id.ed_b)
        val edC:EditText = findViewById(R.id.ed_c)
        val edD:EditText = findViewById(R.id.ed_d)
        val tvCheck:TextView = findViewById(R.id.tv_check)
        val btnCheck:Button = findViewById(R.id.btn_check)

        btnCheck.setOnClickListener {
            val a = edA.text.toString().toInt()
            val b = edB.text.toString().toInt()
            val c = edC.text.toString().toInt()
            val d = edD.text.toString().toInt()
            val putOne = (a > c && b > d)
            val putTwo = (a < c && b < d)
            val result = when {
                putOne -> "Второй конверт можно вложить в первый"
                putTwo -> "Первый конверт можно вложить во второй"
                else -> "Конверты нельзя вложить"
            }
            tvCheck.text = result
        }
    }
}