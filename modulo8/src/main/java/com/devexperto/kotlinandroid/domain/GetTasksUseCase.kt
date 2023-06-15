package com.devexperto.kotlinandroid.domain

import com.devexperto.kotlinandroid.data.TaskRepository
import javax.inject.Inject

class GetTasksUseCase @Inject constructor(private val taskRepository: TaskRepository) {
    operator fun invoke() = taskRepository.getTasks()
}