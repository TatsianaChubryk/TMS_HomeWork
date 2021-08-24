package com.example.homework.hw.homework.lesson23

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework.R

class StudentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val imageStudent = itemView.findViewById<ImageView>(R.id.imgStudent)
    private val nameStudent = itemView.findViewById<TextView>(R.id.nameStudent)
    private val markStudent = itemView.findViewById<TextView>(R.id.markStudent)

    fun bind(studentLiveData: StudentLiveData) {
        Glide
            .with(itemView)
            .load(studentLiveData.image)
            .into(imageStudent)

        nameStudent.text = studentLiveData.nameStudent
        markStudent.text = studentLiveData.markStudent

        if (markStudent.text.toString() <= "5") {
            nameStudent.setTextColor(Color.rgb(200,0,0))
        }  else {
            nameStudent.setTextColor(Color.rgb(0,200,0))
        }
    }
}