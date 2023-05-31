package com.devexperto.kotlinandroid

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.devexperto.modulo3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var taskAdapter: TaskAdapter

    private val viewModel: TasksViewModel by viewModels { TasksViewModelFactory(TaskRepository()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        taskAdapter = TaskAdapter(viewModel::onTaskCheck)

        binding.tasksList.adapter = taskAdapter
        binding.addTask.setOnClickListener {
            viewModel.onTaskAdd(binding.taskInput.text.toString())
        }

        viewModel.items.observe(this, taskAdapter::submitList)
    }
}