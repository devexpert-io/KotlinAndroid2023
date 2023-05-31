package com.devexperto.kotlinandroid.data

interface TaskLocalDataSource {
    suspend fun getTasks(): List<Task>

    suspend fun addTask(task: Task)

    suspend fun updateTask(task: Task)
}