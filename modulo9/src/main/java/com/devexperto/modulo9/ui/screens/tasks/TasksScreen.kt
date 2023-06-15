package com.devexperto.modulo9.ui.screens.tasks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import com.devexperto.modulo9.data.TaskRepository
import com.devexperto.modulo9.domain.AddTaskUseCase
import com.devexperto.modulo9.domain.GetTasksUseCase
import com.devexperto.modulo9.domain.UpdateTaskUseCase
import com.devexperto.modulo9.framework.RoomTaskLocalDataSource

@Composable
fun TasksScreen(viewModel: TasksViewModel = buildTasksViewModel()) {
    val tasks by viewModel.items.collectAsState(emptyList())

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        var newTask by remember { mutableStateOf("") }
        OutlinedTextField(
            value = newTask,
            onValueChange = { newTask = it },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { viewModel.onTaskAdd(newTask) },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Add Task")
        }

        LazyColumn {
            items(tasks) { task ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = task.title,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .weight(1f)
                    )
                    Checkbox(
                        checked = task.completed,
                        onCheckedChange = { viewModel.onTaskCheck(task.copy(completed = !task.completed)) })
                }
            }
        }
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
        UpdateTaskUseCase(taskRepository)
    )
}