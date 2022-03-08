package ru.androidlearning.listsdesign.model.lessons

import ru.androidlearning.listsdesign.domain.HomeWorkInfo
import ru.androidlearning.listsdesign.domain.LessonInfo

interface LessonsRepository {
    suspend fun getLessons(): List<LessonInfo>
    suspend fun getHomeWorks(): List<HomeWorkInfo>
}
