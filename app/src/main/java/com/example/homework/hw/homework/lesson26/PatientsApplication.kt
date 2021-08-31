package com.example.homework.hw.homework.lesson26

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class PatientsApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { PatientsRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { PatientsRepository(database.patientsDao()) }
}