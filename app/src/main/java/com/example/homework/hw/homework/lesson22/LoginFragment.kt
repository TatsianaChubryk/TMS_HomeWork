package com.example.homework.hw.homework.lesson22

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework.R
import com.example.homework.databinding.LoginFragmentBinding

class LoginFragment : Fragment(), View.OnClickListener {

    private var _binding: LoginFragmentBinding? = null
    private val binding get() = _binding
    private var loginError = binding?.tfLogin

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = LoginFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.btnAutho?.setOnClickListener(this)
        binding?.btnAutho?.setOnClickListener {
            if (binding?.tfLogin?.editText?.text.toString().isEmpty() ||
                    binding?.tfPass?.editText?.text.toString().isEmpty()) {
                binding?.tfPass?.error = getString(R.string.errorAutho)
            } else onClick(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        activity?.let {

            val fragment = when (v) {
                binding?.btnAutho -> TaskFragment()
                else -> null
            }

            fragment?.let { frag ->
                it.supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame, frag)
                        .addToBackStack(frag::class.java.canonicalName)
                        .commit()
            }
        }
    }
}