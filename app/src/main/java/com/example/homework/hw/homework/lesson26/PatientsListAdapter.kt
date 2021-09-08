package com.example.homework.hw.homework.lesson26

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework.R

class PatientsListAdapter : ListAdapter<Patients, PatientsListAdapter.PatientsViewHolder>(PATIENTS_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientsViewHolder {
        return PatientsViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: PatientsViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.patients)
    }

    class PatientsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val patientsItemView: TextView = itemView.findViewById(R.id.textView)

        fun bind(text: String?) {
            patientsItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): PatientsViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return PatientsViewHolder(view)
            }
        }
    }

    companion object {
        private val PATIENTS_COMPARATOR = object : DiffUtil.ItemCallback<Patients>() {
            override fun areItemsTheSame(oldItem: Patients, newItem: Patients): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Patients, newItem: Patients): Boolean {
                return oldItem.patients == newItem.patients
            }
        }
    }
}