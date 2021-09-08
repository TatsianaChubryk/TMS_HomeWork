package com.example.homework.hw.homework.lesson27

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.homework.R
import com.example.homework.databinding.FragmentLipstickListBinding

class LipstickListFragment : Fragment(), LipstickListInterface {

    private var _binding: FragmentLipstickListBinding? = null
    private val binding get() = _binding!!
    private val lipstickViewModel: LipstickViewModel by viewModels()
    private val adapter = LipsticksAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLipstickListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lipsticksList.adapter = adapter
        lipstickViewModel.getLipsticksList()

        lipstickViewModel.lipstiksList.observe(viewLifecycleOwner) {
            adapter.setLipstickListAdapter(it)
        }
    }

    override fun onLipstickClick(lipstickID: String) {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.frame, LipstickFragment())
            ?.addToBackStack(LipstickListFragment::class.java.canonicalName)
            ?.commit()
    }
}