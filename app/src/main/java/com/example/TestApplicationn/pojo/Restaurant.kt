package com.example.TestApplicationn.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "testres")
data class Restaurant(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name: String,
    val type: String,
    val logo: String,
    val address: String
)
