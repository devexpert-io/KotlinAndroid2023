package com.devexperto.modulo9.ui.screens.tasks

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.devexperto.modulo9.App
import com.devexperto.modulo9.data.Task
import com.devexperto.modulo9.data.TaskRepository
import com.devexperto.modulo9.domain.AddTaskUseCase
import com.devexperto.modulo9.domain.DeleteAllTasksUseCase
import com.devexperto.modulo9.domain.GetTasksUseCase
import com.devexperto.modulo9.domain.UpdateTaskUseCase
import com.devexperto.modulo9.framework.RoomTaskLocalDataSource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TasksScreen(viewModel: TasksViewModel = buildTasksViewModel()) {
    val tasks by viewModel.items.collectAsState(emptyList())

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Tasks") },
                actions = {
                    IconButton(onClick = { viewModel.onDeleteAllClick() }) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Delete all"
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(16.dp)
                .padding(padding),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            NewTaskForm(onNewTask = viewModel::onTaskAdd)

            LazyColumn {
                items(tasks, key = { it.id }) { task ->
                    TaskItem(
                        task = task,
                        onTaskCheck = { viewModel.onTaskCheck(task.copy(completed = it)) }
                    )
                }
            }
        }
    }
}

@Composable
fun ColumnScope.NewTaskForm(onNewTask: (String) -> Unit) {
    var newTask by remember { mutableStateOf("") }
    OutlinedTextField(
        value = newTask,
        onValueChange = { newTask = it },
        modifier = Modifier.fillMaxWidth()
    )

    Button(
        onClick = { onNewTask(newTask) },
        modifier = Modifier.align(Alignment.End)
    ) {
        Text(text = "Add Task")
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyItemScope.TaskItem(task: Task, onTaskCheck: (Boolean) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.animateItemPlacement()
    ) {
        Text(
            text = task.title,
            modifier = Modifier
                .padding(vertical = 8.dp)
                .weight(1f)
        )
        Checkbox(
            checked = task.completed,
            onCheckedChange = onTaskCheck
        )
    }
}

@Composable
fun buildTasksViewModel(): TasksViewModel {
    val application = LocalContext.current.applicationContext

    val taskRepository = TaskRepository(
        RoomTaskLocalDataSource((application as App).db.taskDao())
    )
    return TasksViewModel(
        GetTasksUseCase(taskRepository),
        AddTaskUseCase(taskRepository),
        UpdateTaskUseCase(taskRepository),
        DeleteAllTasksUseCase(taskRepository)
    )
}