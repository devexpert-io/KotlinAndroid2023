package com.devexperto.kotlinandroid

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TaskRepository {
    private val tasks: MutableList<Task> = mutableListOf()

    fun getTasks(): List<Task> {
        return tasks.toList()
    }

    suspend fun addTask(task: Task) {
        withContext(Dispatchers.IO){
            tasks.add(task)
        }
    }

    suspend fun updateTask(task: Task) {
        withContext(Dispatchers.IO) {
            val index = tasks.indexOfFirst { it.id == task.id }
            if (index != -1) {
                tasks[index] = task
            }
        }
    }
}
