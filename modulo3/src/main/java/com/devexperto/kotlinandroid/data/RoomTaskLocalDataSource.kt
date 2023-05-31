package com.devexperto.kotlinandroid.data

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.Update

class RoomTaskLocalDataSource(
    private val taskDao: TaskDao
) {
    suspend fun getTasks(): List<Task> = taskDao.getTasks()

    suspend fun addTask(task: Task) = taskDao.addTask(task)

    suspend fun updateTask(task: Task) = taskDao.updateTask(task)
}

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}

@Dao
interface TaskDao {

    @Query("SELECT * FROM task ORDER BY completed ASC")
    suspend fun getTasks(): List<Task>

    @Insert
    suspend fun addTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)
}