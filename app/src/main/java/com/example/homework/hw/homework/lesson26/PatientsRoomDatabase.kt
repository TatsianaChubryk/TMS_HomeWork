package com.example.homework.hw.homework.lesson26

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Patients::class], version = 1)
abstract class PatientsRoomDatabase : RoomDatabase() {

    abstract fun patientsDao(): PatientsDao

    companion object {
        @Volatile
        private var INSTANCE: PatientsRoomDatabase? = null

            fun getDatabase(
                context: Context,
                scope: CoroutineScope
        ): PatientsRoomDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PatientsRoomDatabase::class.java,
                    "patients_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(PatientsDatabaseCallback(scope))
                    .build()
                INSTANCE = instance

                instance
            }
        }

        private class PatientsDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {

            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.patientsDao())
                    }
                }
            }
        }

        private suspend fun populateDatabase(patientsDao: PatientsDao) {
            patientsDao.deleteAll()

            var patients = Patients("Kate")
            patientsDao.insert(patients)
            patients = Patients("Anna")
            patientsDao.insert(patients)
        }
    }
}