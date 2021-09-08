package com.example.homework.hw.homework.lesson23

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework.R

class StudentListViewModel: ViewModel() {

    private val _studentList = MutableLiveData<List<StudentLiveData>>()
    val studentList : LiveData<List<StudentLiveData>> = _studentList

    fun createStudentList(){
        _studentList.postValue(listOf(
            StudentLiveData(R.drawable.person, "Григоров Иван", "8"),
            StudentLiveData(R.drawable.person, "Петрова Анна", "5"),
            StudentLiveData(R.drawable.person, "Михайлов Михаил", "3"),
            StudentLiveData(R.drawable.person, "Иванова Ирина", "9"),
            StudentLiveData(R.drawable.person, "Сидоров Семен", "6"),
            StudentLiveData(R.drawable.person, "Иванов Иван", "7"),
            StudentLiveData(R.drawable.person, "Ликумс Анна", "7"),
            StudentLiveData(R.drawable.person, "Борова Инга", "6"),
            StudentLiveData(R.drawable.person, "Шилов Константин", "5"),
            StudentLiveData(R.drawable.person, "Миронов Мирон", "9"),
            StudentLiveData(R.drawable.person, "Петров Олег", "5"),
            StudentLiveData(R.drawable.person, "Прохоров Прохор", "3"),
            StudentLiveData(R.drawable.person, "Игнатов Игнат", "9"),
            StudentLiveData(R.drawable.person, "Борисов Борис", "6")
        )
        )
    }
}