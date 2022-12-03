package com.example.todolist

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.TaskItemCeilBinding

class TaskItemViewHolder(
    private val context: Context,
    private val binding: TaskItemCeilBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bindTaskItem(taskItem: TaskItem) {
        binding.name.text = taskItem.name
    }
}