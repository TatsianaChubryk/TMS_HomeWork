package com.example.homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

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
    }
}