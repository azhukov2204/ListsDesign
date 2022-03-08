package ru.androidlearning.listsdesign.domain

import java.util.*

data class LessonInfo(
    val lessonName: String,
    val beginTime: Calendar,
    val durationMinutes: Int,
    val lector: String,
    val description: String = "",
    val isCanSkypeOpen: Boolean,
    val isAdditionalLesson: Boolean,
    val isNearestPosition: Boolean = false
)
