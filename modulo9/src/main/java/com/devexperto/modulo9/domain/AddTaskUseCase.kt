package com.devexperto.modulo9.domain

import com.devexperto.modulo9.data.Task
import com.devexperto.modulo9.data.TaskRepository

class AddTaskUseCase(private val taskRepository: TaskRepository) {
    suspend operator fun invoke(task: Task) {
        taskRepository.addTask(task)
    }
}