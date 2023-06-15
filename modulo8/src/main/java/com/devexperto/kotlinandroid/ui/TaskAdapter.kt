package com.devexperto.kotlinandroid.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devexperto.kotlinandroid.data.Task
import com.devexperto.modulo8.databinding.ItemTodoBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch

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
            CoroutineScope(Dispatchers.Main).launch {
                binding.checkBoxCompleted.onCheckedEvents.collect { isChecked ->
                    val task = getItem(adapterPosition)
                    onTaskCheck(task.copy(completed = isChecked))
                }
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

val CheckBox.onCheckedEvents: Flow<Boolean>
    get() = callbackFlow {
        setOnCheckedChangeListener { _, isChecked ->
            trySend(isChecked)
        }
        awaitClose { setOnCheckedChangeListener(null) }
    }
