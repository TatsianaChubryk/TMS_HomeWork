package com.example.homework.hw.homework.lesson26

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PatientsActivity : AppCompatActivity() {

    private val newPatientsFragmentRequestCode = 1
    private val patientsViewModel: PatientsViewModel by viewModels {
        PatientsViewModelFactory((application as PatientsApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patients)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = PatientsListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        patientsViewModel.allPatients.observe(this) { words ->
            words.let { adapter.submitList(it) }
        }

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this@PatientsActivity, NewPatientsActivity::class.java)
            startActivityForResult(intent, newPatientsFragmentRequestCode)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newPatientsFragmentRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.getStringExtra(NewPatientsActivity.EXTRA_REPLY)?.let { reply ->
                val word = Patients(reply)
                patientsViewModel.insert(word)
            }
        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG
            ).show()
        }
    }
}