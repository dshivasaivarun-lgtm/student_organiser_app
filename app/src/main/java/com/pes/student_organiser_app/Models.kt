package com.pes.student_organiser_app

data class Course(
    val courseName: String,
    val courseCode: String,
    val instructor: String,
    val progress: Float
)

data class Assignment(
    val id: Int,
    val title: String,
    val course: String,
    val dueDate: String,
    val priority: String,
    val isCompleted: Boolean = false
)