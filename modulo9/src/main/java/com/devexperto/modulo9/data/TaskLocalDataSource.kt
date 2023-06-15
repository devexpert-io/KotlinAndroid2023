package com.devexperto.modulo9.data

import kotlinx.coroutines.flow.Flow

interface TaskLocalDataSource {
    fun getTasks(): Flow<List<Task>>

    suspend fun addTask(task: Task)

    suspend fun updateTask(task: Task)

    suspend fun deleteAllTasks()
}