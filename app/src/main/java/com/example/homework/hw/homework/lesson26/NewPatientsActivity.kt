package com.example.homework.hw.homework.lesson26

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.homework.databinding.ActivityNewPatientsBinding

class NewPatientsActivity : AppCompatActivity() {

    private var _binding: ActivityNewPatientsBinding? = null
    private val binding get() = _binding

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityNewPatientsBinding.inflate(layoutInflater)
        val view = binding?.root
        setContentView(view)

        binding?.btnSave?.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(binding?.etPatients?.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val patients = binding?.etPatients?.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, patients)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }
}