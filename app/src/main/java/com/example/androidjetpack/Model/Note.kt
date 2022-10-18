package com.example.androidjetpack.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "note")
data class Note(
    var data: String,
    var date: String,
    var characters: Long) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
    }

