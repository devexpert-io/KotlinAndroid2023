package com.devexperto.kotlinandroid.data

import com.devexperto.kotlinandroid.framework.RoomTaskLocalDataSource
import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskLocalDataSource: RoomTaskLocalDataSource) {

    fun getTasks(): Flow<List<Task>> = taskLocalDataSource.getTasks()

    suspend fun addTask(task: Task) = taskLocalDataSource.addTask(task)

    suspend fun updateTask(task: Task) = taskLocalDataSource.updateTask(task)
}
