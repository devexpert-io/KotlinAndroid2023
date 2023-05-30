package com.devexperto.kotlinandroid

class TaskRepository {
    private val tasks: MutableList<Task> = mutableListOf()

    fun getTasks(): List<Task> {
        return tasks.toList()
    }

    fun addTask(task: Task) {
        tasks.add(task)
    }

    fun updateTask(task: Task) {
        val index = tasks.indexOfFirst { it.id == task.id }
        if (index != -1) {
            tasks[index] = task
        }
    }
}
