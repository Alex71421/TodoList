package com.example.todolist

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDate
import java.time.LocalTime
import java.util.UUID

class TaskViewModel: ViewModel() {
    // List to store tasks
    var taskItems = MutableLiveData<MutableList<TaskItem>>()

    init {
        taskItems.value = mutableListOf()
    }

    // Function for adding task to the viewModel
    fun addTaskItem(newTask: TaskItem) {
        val list = taskItems.value
        list!!.add(newTask)
        taskItems.postValue(list)
    }

    // Function for updating task in the viewModel
    fun updateTaskItem(id: UUID, name: String, description: String, dueTime: LocalTime?) {
        val list = taskItems.value
        val task = list!!.find { it.id == id }
        task!!.name = name
        task.description = description
        task.dueTime = dueTime
        taskItems.postValue(list)
    }

    // Function for marking the completed task
    @RequiresApi(Build.VERSION_CODES.O)
    fun setCompleted(taskItem: TaskItem) {
        val list = taskItems.value
        val task = list!!.find { it.id == taskItem.id}
        if (taskItem.completedDate == null)
            taskItem.completedDate = LocalDate.now()
        taskItems.postValue(list)
    }
}