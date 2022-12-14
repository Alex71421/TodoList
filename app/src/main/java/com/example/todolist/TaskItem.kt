package com.example.todolist

import java.time.LocalDate
import java.time.LocalTime
import java.util.UUID

class TaskItem(
    var name: String,
    var description: String,
    var id: UUID = UUID.randomUUID()
) {
}