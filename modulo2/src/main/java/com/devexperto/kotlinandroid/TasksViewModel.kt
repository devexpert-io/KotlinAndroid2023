package com.devexperto.kotlinandroid

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class TasksViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    private val _items = savedStateHandle.getLiveData("items", emptyList<Task>())
    val items: LiveData<List<Task>> get() = _items

    fun onTaskAdd(task: String) {
        _items.value?.let { tasks ->
            val newTask = Task(
                id = tasks.size + 1,
                title = task,
                completed = false
            )
            _items.value = tasks + newTask
        }
    }

    fun onTaskCheck(task: Task) {
        _items.value?.let { tasks ->
            val taskIndex = tasks.indexOfFirst { it.id == task.id }
            val newItems = tasks.toMutableList()
            newItems[taskIndex] = task
            newItems.sortBy { it.completed }
            _items.value = newItems
        }
    }
}