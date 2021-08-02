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
    private lateinit var tvDistrict: TextView
    private lateinit var tvVegetables: TextView
    var positionDistrict: Int? = null

    var district = listOf("Бресткая область", "Гродненская область", "Минская область")
    var vegetables = listOf("Картофель", "Капуста", "Свекла")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initAdapter()
        addResult(positionDistrict)
    }

    private fun addResult(positionDistrict: Int?, position2: Int? = null) {
        btnAdd.setOnClickListener {



            /*val amount = etAmount.text.toString().toLong()
            val resPotatoBrest = tvResultPotatoBrest.text.toString().toLong()
            val res = amount + resPotatoBrest
            tvResultPotatoBrest.text = res.toString()*/
           }
    }

    private fun initAdapter() {
        //определяю что я выбрала в выпадающем списке
        val adapterDistrict = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, district)
        adapterDistrict.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerDistrict.adapter = adapterDistrict;
        spinnerDistrict.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //val district = parent!!.getItemAtPosition(position)
                //tvDistrict.text = district
               // addResult(positionDistrict = position)
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
                //Toast.makeText(this@MainActivity, "Selected $position", Toast.LENGTH_LONG).show()
                val Vegetables = parent!!.getItemAtPosition(position).toString()
                tvVegetables.text = Vegetables
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
        tvDistrict = findViewById(R.id.tvDistrict)
        tvVegetables = findViewById(R.id.tvVegetables)
    }
}
