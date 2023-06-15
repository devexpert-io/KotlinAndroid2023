package com.devexperto.kotlinandroid.domain

import com.devexperto.kotlinandroid.data.Task
import com.devexperto.kotlinandroid.data.TaskRepository
import javax.inject.Inject

class UpdateTaskUseCase @Inject constructor(private val taskRepository: TaskRepository) {
    suspend operator fun invoke(task: Task) {
        taskRepository.updateTask(task)
    }
}