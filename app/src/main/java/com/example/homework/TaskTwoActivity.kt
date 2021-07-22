package com.example.homework

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/*
Для введённого пользователем с клавиатуры натурального числа посчитайте сумму всех его цифр
(заранее не известно сколько цифр будет в числе).
*/

class TaskTwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_two)

        val edNumber: EditText = findViewById(R.id.ed_number)
        val btnRes: Button = findViewById(R.id.btn_res)

        btnRes.setOnClickListener{
            resultSum(edNumber)
        }

    }

    private fun resultSum(edNumber: EditText){
        val number = edNumber.text.toString()
        var sum = 0
        for (n in number) {
            val digit: Int = n.toInt()
            sum += ( digit - 48) //В таблице ASCII десятичное значение символа 0 = 48. Если отнять 48 из любого числа, оно преобразуется в целое число.
        }
        val tvRes: TextView = findViewById(R.id.tv_res)
        tvRes.text = sum.toString()
    }
}





