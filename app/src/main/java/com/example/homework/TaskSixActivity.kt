package com.example.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.math.BigInteger

/*
Написать функцию, которая возвращает факториал числа N (n! = 1*2*…*n-1*n;)
*/

class TaskSixActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_six)

        val edNumber:EditText = findViewById(R.id.et_number)
        val btnRes:Button = findViewById(R.id.btn_res)

        btnRes.setOnClickListener {
            Factorial(edNumber)
        }
    }

    private fun Factorial(edNumber: EditText){
        val tvRes:TextView = findViewById(R.id.tv_res)
        val number = edNumber.text.toString().toLong()
        var factorial: Long = 0
        for (i in 1..number)
            factorial *= i.toLong()
            tvRes.text = factorial.toString()
    }
}