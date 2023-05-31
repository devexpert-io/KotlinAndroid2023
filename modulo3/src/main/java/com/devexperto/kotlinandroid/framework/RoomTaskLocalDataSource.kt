package com.devexperto.kotlinandroid.framework

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.Update
import com.devexperto.kotlinandroid.data.Task
import com.devexperto.kotlinandroid.data.TaskLocalDataSource

class RoomTaskLocalDataSource(private val taskDao: TaskDao) : TaskLocalDataSource {
    override suspend fun getTasks(): List<Task> = taskDao.getTasks()

    override suspend fun addTask(task: Task) = taskDao.addTask(task)

    override suspend fun updateTask(task: Task) = taskDao.updateTask(task)
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