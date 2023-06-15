package com.devexperto.modulo9.ui.screens.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devexperto.modulo9.data.Task
import com.devexperto.modulo9.domain.AddTaskUseCase
import com.devexperto.modulo9.domain.DeleteAllTasksUseCase
import com.devexperto.modulo9.domain.GetTasksUseCase
import com.devexperto.modulo9.domain.UpdateTaskUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class TasksViewModel(
    getTasksUseCase: GetTasksUseCase,
    private val addTaskUseCase: AddTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase,
    private val deleteAllTasksUseCase: DeleteAllTasksUseCase
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

    fun onDeleteAllClick() {
        viewModelScope.launch {
            deleteAllTasksUseCase()
        }
    }
}