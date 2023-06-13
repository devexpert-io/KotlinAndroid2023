package com.devexperto.kotlinandroid.data

import com.devexperto.kotlinandroid.framework.RoomTaskLocalDataSource

class TaskRepository(private val taskLocalDataSource: RoomTaskLocalDataSource) {

    suspend fun getTasks(): List<Task> = taskLocalDataSource.getTasks()

    suspend fun addTask(task: Task) = taskLocalDataSource.addTask(task)

    suspend fun updateTask(task: Task) = taskLocalDataSource.updateTask(task)
}
