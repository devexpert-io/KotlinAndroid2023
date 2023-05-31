package com.devexperto.kotlinandroid

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Task(
    val id: Int,
    val title: String,
    val completed: Boolean
) : Parcelable
