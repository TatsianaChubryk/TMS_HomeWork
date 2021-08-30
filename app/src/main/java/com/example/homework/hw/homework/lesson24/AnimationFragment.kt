package com.example.homework.hw.homework.lesson24

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.example.homework.R
import com.example.homework.databinding.FragmentAnimationBinding

class AnimationFragment : Fragment() {

    private var _binding: FragmentAnimationBinding? = null
    private val binding get() = _binding

    private var isAnim = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnimationBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txtAnim = AnimationUtils.loadAnimation(requireContext(),R.anim.text_anim)
        val btnAnim = AnimationUtils.loadAnimation(requireContext(),R.anim.btn_anim)

        txtAnim.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                if(isAnim){
                    binding?.tvAnim?.startAnimation(txtAnim)
                }
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })

        btnAnim.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                if(isAnim){
                    binding?.buttonAnim?.startAnimation(btnAnim)
                }
            }
            override fun onAnimationRepeat(animation: Animation?) {}
        })

        binding?.buttonAnim?.setOnClickListener {
            if (isAnim) {
                binding?.buttonAnim?.text = getString(R.string.start_anim)
                isAnim = false
                txtAnim.cancel()
            } else {
                binding?.buttonAnim?.text = getString(R.string.stop_anim)
                isAnim = true
                binding?.tvAnim?.startAnimation(txtAnim)
                binding?.buttonAnim?.startAnimation(btnAnim)
            }
        }
    }
}