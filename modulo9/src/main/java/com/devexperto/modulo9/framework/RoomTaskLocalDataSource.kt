package com.devexperto.modulo9.framework

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.Update
import com.devexperto.modulo9.data.Task
import com.devexperto.modulo9.data.TaskLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RoomTaskLocalDataSource(private val taskDao: TaskDao) : TaskLocalDataSource {
    override fun getTasks(): Flow<List<Task>> =
        taskDao.getTasks().map { tasks -> tasks.map { it.toTask() } }

    override suspend fun addTask(task: Task) = taskDao.addTask(task.toDbTask())

    override suspend fun updateTask(task: Task) = taskDao.updateTask(task.toDbTask())
}

fun Task.toDbTask() = DbTask(id, title, completed)
fun DbTask.toTask() = Task(id, title, completed)

@Database(entities = [DbTask::class], version = 1, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}

@Dao
interface TaskDao {

    @Query("SELECT * FROM DbTask ORDER BY completed ASC")
    fun getTasks(): Flow<List<DbTask>>

    @Insert
    suspend fun addTask(task: DbTask)

    @Update
    suspend fun updateTask(task: DbTask)
}