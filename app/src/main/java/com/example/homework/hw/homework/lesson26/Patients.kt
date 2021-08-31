package com.example.homework.hw.homework.lesson26

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "patients_table")
data class Patients(@PrimaryKey @ColumnInfo(name = "patients") val patients: String)