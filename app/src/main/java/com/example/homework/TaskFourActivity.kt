package com.example.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

/*Создать класс Cat. Кот имеет свойства имя, вес, цвет, рост, длина и зависящее от веса, роста и длины свойство - сила.
Необходимо создать функцию, определяющую высоту прыжка кота, зависящую от базовых параметров кота (вес, рост, высота).
Создать базовый класс Furniture (мебель), обладающий параметрами: высота, цвет, материал, длина.
На базе класса Furniture создать класс Table (добавить параметр количество ножек).
Реализовать взаимодействие двух объектов: Cat и Table. Вывести получилось ли у кота запрыгнуть на него.*/

class TaskFourActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_four)

        val btnCheckJump:Button = findViewById(R.id.btn_checkJump)
        btnCheckJump.setOnClickListener{

            val etCatName:EditText = findViewById(R.id.et_catName)
            val etCatColor:EditText = findViewById(R.id.et_catColor)
            val etCatWeight:EditText = findViewById(R.id.et_catWeight)
            val etCatLength:EditText = findViewById(R.id.et_catLength)
            val etCatHeight:EditText = findViewById(R.id.et_catHeight)

            val etTableHeight:EditText = findViewById(R.id.et_tableHeight)
            val etTableLength:EditText = findViewById(R.id.et_tableLength)
            val etTableMaterial:EditText = findViewById(R.id.et_tableMaterial)
            val etTableColor:EditText = findViewById(R.id.et_tableColor)
            val etTableLegs:EditText = findViewById(R.id.et_tableLegs)

            val catName:String = etCatName.text.toString()
            val catColor:String = etCatColor.text.toString()
            val catWeight = etCatWeight.text.toString().toInt()
            val catLength = etCatLength.text.toString().toInt()
            val catHeight = etCatHeight.text.toString().toInt()

            val tableHeight = etTableHeight.text.toString().toInt()
            val tableLength = etTableLength.text.toString().toInt()
            val tableMaterial = etTableMaterial.text.toString().toInt()
            val tableColor = etTableColor.text.toString().toInt()
            val tableLegs = etTableLegs.text.toString().toInt()

            val cat = Cat(catName, catColor, catWeight, catLength, catHeight)
            val table = Table(tableHeight, tableLength, tableMaterial, tableColor, tableLegs)
            checkJump(cat, table)

        }
    }

    private fun checkJump(cat: Cat, table: Table) {

        val tvResultJump: TextView = findViewById(R.id.tv_resultJump)
        val tablePower = (table.length + table.height * 3) + table.legs
        if (cat.catPower > tablePower) {
            tvResultJump.text = ("У вас супер кот")
        }else {
            tvResultJump.text = ("Увы, кот не смог взять высоту")
        }

    }
}