package com.example.homework.hw.homework.lesson23

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework.R

class StudentListAdapter: RecyclerView.Adapter<StudentViewHolder>() {

    var listStudent: List<StudentLiveData> = mutableListOf()

    fun setStudentListAdapter(studentListData: List<StudentLiveData>){
        listStudent = studentListData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_mark_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(listStudent[position])
    }

    override fun getItemCount(): Int = listStudent.size
}