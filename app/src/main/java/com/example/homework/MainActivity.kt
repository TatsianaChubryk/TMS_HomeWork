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

    private fun addResult(positionDistrict: Int?, positionVegetables: Int?) {
        btnAdd.setOnClickListener {
            val amount = etAmount.text.toString().toLong()
            val potatoBrest = tvResultPotatoBrest.text.toString().toLong()
            val beetBrest = tvResultBeetBrest.text.toString().toLong()
            val cabbageBrest = tvResultCabbageBrest.text.toString().toLong()
            var resCabbageBrest = 0
            var resPotatoBrest = 0
            var resBeetBrest = 0

            when {
                positionDistrict == 1 && positionVegetables == 1 -> resPotatoBrest = (amount + potatoBrest).toInt()
                positionDistrict == 1 && positionVegetables == 2 -> resCabbageBrest = (amount + cabbageBrest).toInt()
                positionDistrict == 1 && positionVegetables == 3 -> tvResultBeetBrest.text = (amount + beetBrest).toString()

            }


            tvResultCabbageBrest.text = resCabbageBrest.toString()
            /*resCabbageBrest = (amount + cabbageBrest).toInt()
            tvResultCabbageBrest.text = resCabbageBrest.toString()*/

        }
    }

    private fun initAdapter() {
        //определяю что я выбрала в выпадающем списке
        val adapterDistrict = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, district)
        adapterDistrict.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerDistrict.adapter = adapterDistrict;
        spinnerDistrict.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                /* val district1 = parent!!.getItemAtPosition(position)
                 tvDistrict.text = district1*/
                //addResult(positionDistrict = position)
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
                /*val Vegetables = parent!!.getItemAtPosition(position).toString()
                tvVegetables.text = Vegetables
                positionVegetables = position*/
                //addResult(positionVegetables = position)
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
        tvDistrict = findViewById(R.id.tvDistrict)
        tvVegetables = findViewById(R.id.tvVegetables)
    }
}
