package com.devexperto.kotlinandroid.domain

import com.devexperto.kotlinandroid.data.Task
import com.devexperto.kotlinandroid.data.TaskRepository

class AddTaskUseCase(private val taskRepository: TaskRepository) {
    suspend operator fun invoke(task: Task) {
        taskRepository.addTask(task)
    }
}