package com.example.homework.hw.homework.lesson26

import androidx.annotation.WorkerThread
import androidx.room.Dao
import kotlinx.coroutines.flow.Flow

class PatientsRepository(private val patientsDao: PatientsDao) {
    val allPatients: Flow<List<Patients>> = patientsDao.getAlphabetizedWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(patients: Patients) {
        patientsDao.insert(patients)
    }
}