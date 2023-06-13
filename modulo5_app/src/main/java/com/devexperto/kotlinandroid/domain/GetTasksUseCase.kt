package com.devexperto.kotlinandroid.domain

import com.devexperto.kotlinandroid.data.TaskRepository

class GetTasksUseCase(private val taskRepository: TaskRepository) {
    suspend operator fun invoke() = taskRepository.getTasks()
}