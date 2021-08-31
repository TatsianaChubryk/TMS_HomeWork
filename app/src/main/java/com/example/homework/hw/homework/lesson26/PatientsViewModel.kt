package com.example.homework.hw.homework.lesson26

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class PatientsViewModel(private val repository: PatientsRepository) : ViewModel() {

    val allPatients: LiveData<List<Patients>> = repository.allPatients.asLiveData()

    fun insert(patients: Patients) = viewModelScope.launch {
        repository.insert(patients)
    }
}

class PatientsViewModelFactory(private val repository: PatientsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PatientsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PatientsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}