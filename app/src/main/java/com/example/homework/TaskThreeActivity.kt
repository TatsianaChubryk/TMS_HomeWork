package com.example.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

/*Написать программу определения оценки студента по его рейтингу, на основе следующих правил:
рейтинг Оценка
0-19 F
20-39 E
40-59 D
60-74 C
75-89 B
90-100 A*/


class TaskThreeActivity : AppCompatActivity() {
    enum class Grade {
        F, E, D, C, B, A, Z
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_three)

        val etRating:EditText = findViewById(R.id.et_rating)
        val btnRating:Button = findViewById(R.id.btn_rating)
        val tvRating:TextView = findViewById(R.id.tv_rating)

        btnRating.setOnClickListener {
            val grade = when (etRating.text.toString().toInt()){
                in 0..19 -> Grade.F
                in 20..39 -> Grade.E
                in 40..59 -> Grade.D
                in 60..74 -> Grade.C
                in 75..89 -> Grade.B
                in 90..100 -> Grade.A
                else -> Grade.Z
            }

            tvRating.text = ("Оценка студента: $grade")
        }
    }
}