package com.devexperto.modulo9.data

import com.devexperto.modulo9.framework.RoomTaskLocalDataSource
import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskLocalDataSource: RoomTaskLocalDataSource) {

    fun getTasks(): Flow<List<Task>> = taskLocalDataSource.getTasks()

    suspend fun addTask(task: Task) = taskLocalDataSource.addTask(task)

    suspend fun updateTask(task: Task) = taskLocalDataSource.updateTask(task)

    suspend fun deleteAllTasks() = taskLocalDataSource.deleteAllTasks()
}
