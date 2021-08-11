package com.example.homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.homework.databinding.FragmentHw20Binding

//Timer с сохранением состояния при повороте экрана (использовать ViewModel и LiveData)

class TimerFragment: Fragment() {

    private var _binding: FragmentHw20Binding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy {
        ViewModelProvider(this).get(TimerActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHw20Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTvSeconds()
        binding.btnStart.setOnClickListener {
            binding.btnStart.isEnabled = false
            val seconds = if (binding.etSecond.text.toString() != "")
                binding.etSecond.text.toString().toLong()
            else
                0
            viewModel.startTimer(seconds)
            setTvSeconds()
        }
        listenCount()
    }

    private fun listenCount(){
        viewModel.isFinishLD.observe(viewLifecycleOwner, {
            if (it)
                binding.btnStart.isEnabled = true
        })
    }

    private fun setTvSeconds() {
        viewModel.liveData.observe(viewLifecycleOwner, {
            binding.tvTimer.text = it
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}