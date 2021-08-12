package com.example.homework.hw.homework.lesson

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.homework.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnTaskOne:Button = findViewById(R.id.btn_taskOne)
        btnTaskOne.setOnClickListener {
            val intent = Intent(this, TaskOneActivity::class.java)
            startActivity(intent)
        }

        val btnTaskTwo:Button = findViewById(R.id.btn_taskTwo)
        btnTaskTwo.setOnClickListener {
            val intent = Intent(this, TaskTwoActivity::class.java)
            startActivity(intent)
        }

        val btnTaskThree:Button = findViewById(R.id.btn_taskThree)
        btnTaskThree.setOnClickListener {
            val intent = Intent(this, TaskThreeActivity::class.java)
            startActivity(intent)
        }

        val btnTaskFour:Button = findViewById(R.id.btn_taskFour)
        btnTaskFour.setOnClickListener {
            val intent = Intent(this, TaskFourActivity::class.java)
            startActivity(intent)
        }

        val btnTaskFive:Button = findViewById(R.id.btn_taskFive)
        btnTaskFive.setOnClickListener {
            val intent = Intent(this, TaskFiveActivity::class.java)
            startActivity(intent)
        }

        val btnTaskSix:Button = findViewById(R.id.btn_taskSix)
        btnTaskSix.setOnClickListener {
            val intent = Intent(this, TaskSixActivity::class.java)
            startActivity(intent)
        }
    }
}