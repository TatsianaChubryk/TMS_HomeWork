package com.example.homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnTaskOne:Button = findViewById(R.id.btn_taskOne)
        val btnTaskTwo:Button = findViewById(R.id.btn_taskTwo)
        val btnTaskThree:Button = findViewById(R.id.btn_taskThree)
        val btnTaskFour:Button = findViewById(R.id.btn_taskFour)

        btnTaskOne.setOnClickListener {
            val intent = Intent(this, TaskOneActivity::class.java)
            startActivity(intent)
        }

        btnTaskTwo.setOnClickListener {
            val intent = Intent(this, TaskTwoActivity::class.java)
            startActivity(intent)
        }

        btnTaskThree.setOnClickListener {
            val intent = Intent(this, TaskThreeActivity::class.java)
            startActivity(intent)
        }

        btnTaskFour.setOnClickListener {
            val intent = Intent(this, TaskFourActivity::class.java)
            startActivity(intent)
        }
    }
}