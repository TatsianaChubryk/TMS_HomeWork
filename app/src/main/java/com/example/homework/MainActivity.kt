package com.example.homework14

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_taskOne = findViewById<View>(R.id.btn_taskOne) as Button
        btn_taskOne.setOnClickListener {
            val intent = Intent(this, TaskOneActivity::class.java)
            startActivity(intent)
        }

        val btn_taskTwo = findViewById<View>(R.id.btn_taskTwo) as Button
        btn_taskTwo.setOnClickListener {
            val intent = Intent(this, TaskTwoActivity::class.java)
            startActivity(intent)
        }


    }

}