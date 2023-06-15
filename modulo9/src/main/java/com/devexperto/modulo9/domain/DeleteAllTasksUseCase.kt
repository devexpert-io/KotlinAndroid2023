package com.devexperto.modulo9.domain

import com.devexperto.modulo9.data.TaskRepository

class DeleteAllTasksUseCase(private val taskRepository: TaskRepository) {
    suspend operator fun invoke() {
        taskRepository.deleteAllTasks()
    }
}