package com.devexperto.kotlinandroid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devexperto.modulo3.databinding.ItemTodoBinding

class TaskAdapter(private val onTaskCheck: (Task) -> Unit) :
    ListAdapter<Task, TaskAdapter.TaskViewHolder>(TaskDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding, onTaskCheck)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = getItem(position)
        holder.bind(task)
    }

    inner class TaskViewHolder(private val binding: ItemTodoBinding, onTaskCheck: (Task) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.checkBoxCompleted.setOnCheckedChangeListener { _, isChecked ->
                val task = getItem(adapterPosition)
                onTaskCheck(task.copy(completed = isChecked))
            }
        }

        fun bind(task: Task) {
            binding.textViewTitle.text = task.title
            binding.checkBoxCompleted.isChecked = task.completed
        }
    }

    class TaskDiffCallback : DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem == newItem
        }
    }
}
