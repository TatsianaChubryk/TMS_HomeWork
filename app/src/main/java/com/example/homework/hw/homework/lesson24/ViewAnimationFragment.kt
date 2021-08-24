package com.example.homework.hw.homework.lesson24

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.example.homework.R
import com.example.homework.databinding.FragmentViewAnimationBinding

class ViewAnimationFragment : Fragment() {

    private var _binding: FragmentViewAnimationBinding? = null
    private val binding get() = _binding

    private var isAnim = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentViewAnimationBinding.inflate(inflater, container, false)
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
                    binding?.textDance?.startAnimation(txtAnim)
                }
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })

        btnAnim.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                if(isAnim){
                    binding?.buttonDance?.startAnimation(btnAnim)
                }
            }
            override fun onAnimationRepeat(animation: Animation?) {}
        })

        binding?.buttonDance?.setOnClickListener {
            if (isAnim) {
                binding?.buttonDance?.text = getString(R.string.start_anim)
                isAnim = false
                txtAnim.cancel()
                btnAnim.cancel()
            } else {
                binding?.buttonDance?.text = getString(R.string.stop_anim)
                isAnim = true
                binding?.textDance?.startAnimation(txtAnim)
                binding?.buttonDance?.startAnimation(btnAnim)
            }
        }
    }
}