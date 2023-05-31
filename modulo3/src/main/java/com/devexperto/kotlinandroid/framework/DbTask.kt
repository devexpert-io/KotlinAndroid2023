package com.devexperto.kotlinandroid.framework

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DbTask(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val completed: Boolean
)
