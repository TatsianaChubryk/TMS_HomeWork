package com.example.homework.hw.homework.lesson26

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PatientsDao {

    // The flow always holds/caches latest version of data. Notifies its observers when the
    // data has changed.
    @Query("SELECT * FROM patients_table ORDER BY patients ASC")
    fun getAlphabetizedWords(): Flow<List<Patients>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(patients: Patients)

    @Query("DELETE FROM patients_table")
    suspend fun deleteAll()
}