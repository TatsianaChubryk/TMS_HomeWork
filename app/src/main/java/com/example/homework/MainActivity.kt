package com.example.homework

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var spinnerDistrict: Spinner
    private lateinit var spinnerVegetables: Spinner
    private lateinit var etAmount: EditText
    private lateinit var btnAdd: Button
    private lateinit var tvResultPotatoBrest: TextView
    private lateinit var tvResultCabbageBrest: TextView
    private lateinit var tvResultBeetBrest: TextView
    private lateinit var tvResultPotatoGrodno: TextView
    private lateinit var tvResultCabbageGrodno: TextView
    private lateinit var tvResultBeetGrodno: TextView
    private lateinit var tvResultPotatoMinsk: TextView
    private lateinit var tvResultCabbageMinsk: TextView
    private lateinit var tvResultBeetMinsk: TextView
    var positionDistrict: Int? = null
    var positionVegetables: Int? = null

    var district = listOf("Бресткая область", "Гродненская область", "Минская область")
    var vegetables = listOf("Картофель", "Капуста", "Свекла")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initAdapter()
        addResult(positionDistrict, positionVegetables)
    }

    private fun addResult(positionVegetables: Int?, positionDistrict: Int?) {
        btnAdd.setOnClickListener {
            val amount = etAmount.text.toString().toInt()
            val potatoBrest = tvResultPotatoBrest.text.toString().toInt()
            val beetBrest = tvResultBeetBrest.text.toString().toInt()
            val cabbageBrest = tvResultCabbageBrest.text.toString().toInt()
            val potatoGrodno = tvResultPotatoGrodno.text.toString().toInt()
            val beetGrodno = tvResultBeetGrodno.text.toString().toInt()
            val cabbageGrodno = tvResultCabbageGrodno.text.toString().toInt()
            val potatoMinsk = tvResultPotatoMinsk.text.toString().toInt()
            val beetMinsk = tvResultBeetMinsk.text.toString().toInt()
            val cabbageMinsk = tvResultCabbageMinsk.text.toString().toInt()
            when {
                this.positionDistrict == 0 && this.positionVegetables == 0 -> tvResultPotatoBrest.text = (amount + potatoBrest).toString()
                this.positionDistrict == 0 && this.positionVegetables == 1 -> tvResultCabbageBrest.text = (amount + cabbageBrest).toString()
                this.positionDistrict == 0 && this.positionVegetables == 2 -> tvResultBeetBrest.text = (amount + beetBrest).toString()
                this.positionDistrict == 1 && this.positionVegetables == 0 -> tvResultPotatoGrodno.text = (amount + potatoGrodno).toString()
                this.positionDistrict == 1 && this.positionVegetables == 1 -> tvResultCabbageGrodno.text = (amount + cabbageGrodno).toString()
                this.positionDistrict == 1 && this.positionVegetables == 2 -> tvResultBeetGrodno.text = (amount + beetGrodno).toString()
                this.positionDistrict == 2 && this.positionVegetables == 0 -> tvResultPotatoMinsk.text = (amount + potatoMinsk).toString()
                this.positionDistrict == 2 && this.positionVegetables == 1 -> tvResultCabbageMinsk.text = (amount + cabbageMinsk).toString()
                this.positionDistrict == 2 && this.positionVegetables == 2 -> tvResultBeetMinsk.text = (amount + beetMinsk).toString()
            }
        }
    }

    private fun initAdapter() {
        val adapterDistrict = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, district)
        adapterDistrict.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerDistrict.adapter = adapterDistrict;
        spinnerDistrict.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                positionDistrict = position
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        val adapterVegetables = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, vegetables)
        adapterVegetables.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerVegetables.adapter = adapterVegetables;
        spinnerVegetables.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
               positionVegetables = position
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

    }

    private fun initView() {
        spinnerDistrict = findViewById(R.id.spinnerDistrict)
        spinnerVegetables = findViewById(R.id.spinnerVegetable)
        etAmount = findViewById(R.id.etAmount)
        btnAdd = findViewById(R.id.btnAdd)
        tvResultPotatoBrest = findViewById(R.id.tvResultPotatoBrest)
        tvResultCabbageBrest = findViewById(R.id.tvResultCabbageBrest)
        tvResultBeetBrest = findViewById(R.id.tvResultBeetBrest)
        tvResultPotatoGrodno = findViewById(R.id.tvResultPotatoGrodno)
        tvResultCabbageGrodno = findViewById(R.id.tvResultCabbageGrodno)
        tvResultBeetGrodno = findViewById(R.id.tvResultBeetGrodno)
        tvResultPotatoMinsk = findViewById(R.id.tvResultPotatoMinsk)
        tvResultCabbageMinsk = findViewById(R.id.tvResultCabbageMinsk)
        tvResultBeetMinsk = findViewById(R.id.tvResultBeetMinsk)
    }
}
