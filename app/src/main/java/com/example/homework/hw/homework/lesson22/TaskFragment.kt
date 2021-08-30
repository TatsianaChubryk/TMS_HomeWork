package com.example.homework.hw.homework.lesson22

import android.os.Bundle
import android.text.TextUtils
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.homework.R
import com.example.homework.databinding.TaskFragmentBinding
import com.example.homework.hw.homework.lesson21.MediaPlayerFragment
import com.example.homework.hw.homework.lesson23.StudentListFragment
import com.example.homework.hw.homework.lesson24.AnimationFragment

class TaskFragment : Fragment(), View.OnClickListener {

    private var _binding: TaskFragmentBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = TaskFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        binding?.btnLesson22?.setOnClickListener(this)
        binding?.btnLesson23?.setOnClickListener(this)
        binding?.btnLesson24?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        activity?.let{
            val fragment = when (v) {
                binding?.btnLesson22 -> MediaPlayerFragment()
                binding?.btnLesson23 -> StudentListFragment()
                binding?.btnLesson24 -> AnimationFragment()
                else -> null
            }

            fragment?.let { frag ->
                it.supportFragmentManager.commit {
                    setCustomAnimations(
                        R.anim.slide_out,
                        R.anim.slide_in,
                        R.anim.back_in,
                        R.anim.back_out
                    )
                    replace(R.id.frame, frag)
                    addToBackStack(frag::class.java.canonicalName)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null

    }
}