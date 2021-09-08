package com.example.homework.hw.homework.lesson27

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.homework.R
import com.example.homework.databinding.FragmentLipsticksDetailsBinding

class LipstickFragment : Fragment() {

    private var _binding: FragmentLipsticksDetailsBinding? = null
    private val binding get() = _binding!!
    private val lipstickViewModel: LipstickViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLipsticksDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lipstickViewModel.lipstick.observe(viewLifecycleOwner, { lipstick ->
            binding.lipstickImage.let {
                Glide.with(requireContext())
                    .load(lipstick.image_link)
                    .placeholder(R.drawable.lipstick)
                    .into(it)
            }

            binding.lipstickBrand.text = lipstick.brand
            binding.lipstickName.text = lipstick.name
            binding.lipstickPrice.text = lipstick.price
            binding.lipstickDescription.text = lipstick.description
        })

    }
}