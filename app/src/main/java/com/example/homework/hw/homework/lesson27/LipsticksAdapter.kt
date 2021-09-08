package com.example.homework.hw.homework.lesson27

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework.R
import com.example.homework.hw.homework.lesson27.model.LipstickItem

class LipsticksAdapter(
    private val listener: LipstickListInterface
) : RecyclerView.Adapter<LipstickViewHolder>() {

    var listLipstick: List<LipstickItem> = mutableListOf()

    fun setLipstickListAdapter(lipstickLiveData: List<LipstickItem>) {
        listLipstick = lipstickLiveData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LipstickViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lipsticks, parent, false)
        return LipstickViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: LipstickViewHolder, position: Int) {
        holder.bind(listLipstick[position])
    }

    override fun getItemCount(): Int = listLipstick.size
}