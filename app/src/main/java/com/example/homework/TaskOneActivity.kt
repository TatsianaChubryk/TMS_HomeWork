package com.example.homework14

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class TaskOneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_one)

        val btn_answer = findViewById<View>(R.id.btn_answer)
        val tv_answer = findViewById<View>(R.id.tv_answer) as TextView

        btn_answer.setOnClickListener {
            val random = Random()
            val list = Arrays.asList("Да", "Нет", "Скорее всего да", "Скорее всего нет", "Возможно", "Имеются перспективы", "Вопрос задан неверно")
            val randomAnswer = list.get(random.nextInt(list.size));
            tv_answer.setText("$randomAnswer")
        }

        val btn_back = findViewById<View>(R.id.btn_back)
        btn_back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}







