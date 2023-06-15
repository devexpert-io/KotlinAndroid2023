package com.devexperto.modulo9

import android.app.Application
import androidx.room.Room
import com.devexperto.modulo9.framework.TaskDatabase

class App : Application() {

    lateinit var db: TaskDatabase

    override fun onCreate() {
        super.onCreate()
        db = Room
            .databaseBuilder(this, TaskDatabase::class.java, "task-db")
            .build()
    }

}