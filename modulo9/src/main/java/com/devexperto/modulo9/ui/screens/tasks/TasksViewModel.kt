package com.devexperto.modulo9.ui.screens.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.devexperto.modulo9.data.Task
import com.devexperto.modulo9.domain.AddTaskUseCase
import com.devexperto.modulo9.domain.GetTasksUseCase
import com.devexperto.modulo9.domain.UpdateTaskUseCase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class TasksViewModel(
    getTasksUseCase: GetTasksUseCase,
    private val addTaskUseCase: AddTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase,
) : ViewModel() {

    val items: Flow<List<Task>> = getTasksUseCase()

    fun onTaskAdd(task: String) {
        viewModelScope.launch {
            addTaskUseCase(Task(0, task, false))
        }
    }

    fun onTaskCheck(task: Task) {
        viewModelScope.launch {
            updateTaskUseCase(task)
        }
    }
}

@Suppress("UNCHECKED_CAST")
class TasksViewModelFactory(
    private val getTasksUseCase: GetTasksUseCase,
    private val addTaskUseCase: AddTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TasksViewModel(getTasksUseCase, addTaskUseCase, updateTaskUseCase) as T
    }
}