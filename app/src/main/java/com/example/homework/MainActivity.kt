package com.example.homework

import android.R.attr.data
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    private lateinit var spinnerDistrict: Spinner
    private lateinit var spinnerVegetables: Spinner
    private lateinit var etAmount: EditText
    private lateinit var btnAdd: Button
    private lateinit var tvResultPotatoBrest: TextView
    private lateinit var tvResultCabbageBrest: TextView
    private lateinit var tvResultBeetBrest: TextView

    var district = listOf("Бресткая область", "Гродненская область", "Минская область")
    var vegetables = listOf("Картофель", "Капуста", "Свекла")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initAdapter()
        addResult()
    }

    private fun addResult(){
        // килограммы / 1000 и будут тонны

    }

    private fun initAdapter(){
        val adapterDistrict = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, district)
        adapterDistrict.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerDistrict.adapter = adapterDistrict;

        val adapterVegetables = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, vegetables)
        adapterVegetables.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerVegetables.adapter = adapterVegetables;
    }

    private fun initView(){
        spinnerDistrict = findViewById(R.id.spinnerDistrict)
        spinnerVegetables = findViewById(R.id.spinnerVegetable)
        etAmount = findViewById(R.id.etAmount)
        btnAdd = findViewById(R.id.btnAdd)
        tvResultPotatoBrest = findViewById(R.id.tvResultPotatoBrest)
        tvResultCabbageBrest = findViewById(R.id.tvResultCabbageBrest)
        tvResultBeetBrest = findViewById(R.id.tvResultBeetBrest)
    }
}