package com.devexperto.kotlinandroid.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.devexperto.kotlinandroid.data.Task
import com.devexperto.kotlinandroid.domain.AddTaskUseCase
import com.devexperto.kotlinandroid.domain.GetTasksUseCase
import com.devexperto.kotlinandroid.domain.UpdateTaskUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TasksViewModel(
    private val getTasksUseCase: GetTasksUseCase,
    private val addTaskUseCase: AddTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase,
) : ViewModel() {

    private val _items = MutableStateFlow<List<Task>>(emptyList())
    val items: StateFlow<List<Task>> = _items.asStateFlow()

    init {
        viewModelScope.launch {
            _items.value = getTasksUseCase()
        }
    }

    fun onTaskAdd(task: String) {
        viewModelScope.launch {
            addTaskUseCase(Task(0, task, false))
            _items.value = getTasksUseCase()
        }
    }

    fun onTaskCheck(task: Task) {
        viewModelScope.launch {
            updateTaskUseCase(task)
            _items.value = getTasksUseCase()
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