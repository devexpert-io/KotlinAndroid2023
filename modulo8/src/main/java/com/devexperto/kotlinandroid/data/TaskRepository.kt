package com.devexperto.kotlinandroid.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskRepository @Inject constructor(private val taskLocalDataSource: TaskLocalDataSource) {

    fun getTasks(): Flow<List<Task>> = taskLocalDataSource.getTasks()

    suspend fun addTask(task: Task) = taskLocalDataSource.addTask(task)

    suspend fun updateTask(task: Task) = taskLocalDataSource.updateTask(task)
}
