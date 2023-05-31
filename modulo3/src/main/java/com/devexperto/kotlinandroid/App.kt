package com.devexperto.kotlinandroid

import android.app.Application
import androidx.room.Room
import com.devexperto.kotlinandroid.framework.TaskDatabase

class App : Application() {

    lateinit var db: TaskDatabase

    override fun onCreate() {
        super.onCreate()
        db = Room
            .databaseBuilder(this, TaskDatabase::class.java, "task-db")
            .build()
    }

}