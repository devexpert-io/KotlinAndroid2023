package com.devexperto.kotlinandroid.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devexperto.kotlinandroid.data.Task
import com.devexperto.kotlinandroid.domain.AddTaskUseCase
import com.devexperto.kotlinandroid.domain.GetTasksUseCase
import com.devexperto.kotlinandroid.domain.UpdateTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor(
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