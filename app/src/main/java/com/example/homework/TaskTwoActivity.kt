@file:Suppress("UNREACHABLE_CODE")

package com.example.homework14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*


class TaskTwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_two)

        val brainteaserOne = "\n" +
                "Кто по ёлкам ловко скачет\n" +
                "И взлетает на дубы?\n" +
                "Кто в дупле орехи прячет,\n" +
                "Сушит на зиму грибы?"
        val brainteaserTwo = "\n" +
                "В клубок свернётся,\n" +
                "А взять не даётся."
        val brainteaserThree = "\n" +
                "У него огромный рот,\n" +
                "Он зовется …"

        val random = Random()
        val list = Arrays.asList(brainteaserOne, brainteaserTwo, brainteaserThree)
        val randomAnswer = list.get(random.nextInt(list.size));
        val tv_Brainteaser = findViewById<View>(R.id.tv_Brainteaser) as TextView
        tv_Brainteaser.text = randomAnswer

        val btn_answerOne = findViewById<View>(R.id.btn_answerOne) as Button
        val btn_answerTwo = findViewById<View>(R.id.btn_answerTwo) as Button
        val btn_answerThree = findViewById<View>(R.id.btn_answerThree) as Button
        val tv_answer = findViewById<View>(R.id.tv_answer) as TextView

        btn_answerOne.setOnClickListener{
            if (randomAnswer == brainteaserOne){
                tv_answer.setText("Отгадали")
            }
            else{
                tv_answer.setText("Не отгадали")
            }
        }

        btn_answerTwo.setOnClickListener{
            if (randomAnswer == brainteaserTwo){
                tv_answer.setText("Отгадали")
            }
            else{
                tv_answer.setText("Не отгадали")
            }
        }

        btn_answerThree.setOnClickListener{
            if (randomAnswer == brainteaserThree){
                tv_answer.setText("Отгадали")
            }
            else{
                tv_answer.setText("Не отгадали")
            }
        }

        val btn_back = findViewById<View>(R.id.btn_back2)
        btn_back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

 }


