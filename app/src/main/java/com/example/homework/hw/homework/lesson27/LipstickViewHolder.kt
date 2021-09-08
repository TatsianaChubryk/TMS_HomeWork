package com.example.homework.hw.homework.lesson27

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework.R
import com.example.homework.hw.homework.lesson27.model.LipstickItem

class LipstickViewHolder(
    itemLipstickView: View,
    private val listener: LipstickListInterface
) : RecyclerView.ViewHolder(itemLipstickView) {

    private val lipstickImage = itemLipstickView.findViewById<ImageView>(R.id.lipstickImage)
    private val lipstickName = itemLipstickView.findViewById<TextView>(R.id.lipstickName)

    fun bind(lipstickItem: LipstickItem) {
        Glide.with(itemView)
            .load(lipstickItem.image_link)
            .placeholder(R.drawable.lipstick)
            .into(lipstickImage)

        lipstickName.text = lipstickItem.name

        itemView.setOnClickListener {
            listener.onLipstickClick(lipstickItem.name)
        }
    }
}