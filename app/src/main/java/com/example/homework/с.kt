import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.homework.TimerViewModel

package com.example.tmsandroid.dz.dz20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

class Dz20Fragment : Fragment() {
   /* private var _binding: FragmentDz20Binding? = null
    private val binding get() = _binding!!*/

    private lateinit var etSecond: EditText
    private lateinit var btnStart: Button
    private lateinit var tvTimer: TextView

    private val timer by lazy {
        ViewModelProvider(this).get(TimerViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

   /* override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDz20Binding.inflate(inflater, container, false)
        return binding.root
    }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTvSeconds()
        btnStart.setOnClickListener {
            val second = if (etSecond.text.toString() != "")
                etSecond.text.toString().toLong()
            else
                0
            timer.startTimer(second)
            // second = etSecond.text.toString().toLong()
            setTvSeconds()
        }
    }

    private fun setTvSeconds() {
        timer.liveData.observe(viewLifecycleOwner, {
            tvTimer.text = it
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        tvTimer.text = null
    }
}
