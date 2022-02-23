package ru.androidlearning.listsdesign.domain

import java.util.*

data class HomeWorkInfo(
    val lessonName: String,
    val description: String,
    val deadline: Calendar
)
