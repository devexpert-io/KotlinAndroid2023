package com.devexperto.kotlinandroid.data

import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskLocalDataSource: TaskLocalDataSource) {

    fun getTasks(): Flow<List<Task>> = taskLocalDataSource.getTasks()

    suspend fun addTask(task: Task) = taskLocalDataSource.addTask(task)

    suspend fun updateTask(task: Task) = taskLocalDataSource.updateTask(task)
}
