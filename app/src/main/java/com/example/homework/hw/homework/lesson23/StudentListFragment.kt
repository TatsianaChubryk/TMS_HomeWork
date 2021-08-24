package com.example.homework.hw.homework.lesson23

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.homework.R

class StudentListFragment : Fragment() {

    private val adapter = StudentListAdapter()
    private val vm : StudentListViewModel by viewModels()
    private lateinit var studentListRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_student_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        studentListRecyclerView = view.findViewById(R.id.studentListRecView)
        studentListRecyclerView.adapter = adapter

        vm.studentList.observe(viewLifecycleOwner) {
            adapter.setStudentListAdapter(it)
        }
        vm.createStudentList()
    }
}