package com.devexperto.kotlinandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devexperto.kotlinandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var taskAdapter: TaskAdapter
    private val items = mutableListOf<Task>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        taskAdapter = TaskAdapter(::updateTask)

        binding.tasksList.adapter = taskAdapter

        binding.addTask.setOnClickListener {

            val task = Task(
                id = items.size + 1,
                title = binding.taskInput.text.toString(),
                completed = false
            )

            items.add(task)

            taskAdapter.submitList(items.toList())
        }
    }

    private fun updateTask(task: Task) {
        val taskIndex = items.indexOfFirst { it.id == task.id }
        items[taskIndex] = task
        items.sortBy { it.completed }
        taskAdapter.submitList(items.toList())
    }
}