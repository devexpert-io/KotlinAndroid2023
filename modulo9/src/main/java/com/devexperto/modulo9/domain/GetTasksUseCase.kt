package com.devexperto.modulo9.domain

import com.devexperto.modulo9.data.TaskRepository

class GetTasksUseCase(private val taskRepository: TaskRepository) {
    operator fun invoke() = taskRepository.getTasks()
}