package ru.androidlearning.listsdesign.model.lessons

import ru.androidlearning.listsdesign.domain.HomeWorkInfo
import ru.androidlearning.listsdesign.domain.LessonInfo
import java.util.*

class LessonsRepositoryImpl : LessonsRepository {

    override suspend fun getLessons(): List<LessonInfo> {
        val today = Calendar.getInstance()
        val year = today.get(Calendar.YEAR)
        val month = today.get(Calendar.MONTH)
        val dayOfMonth = today.get(Calendar.DAY_OF_MONTH)
        val hourOfDay = today.get(Calendar.HOUR_OF_DAY)
        return listOf(
            LessonInfo(
                lessonName = "История",
                beginTime = Calendar.getInstance().apply {
                    set(Calendar.YEAR, year)
                    set(Calendar.MONTH, month)
                    set(Calendar.DAY_OF_MONTH, dayOfMonth - 1)
                    set(Calendar.HOUR_OF_DAY, hourOfDay - 1)
                    set(Calendar.MINUTE, 0)
                    timeZone = TimeZone.getDefault()
                },
                durationMinutes = 60,
                lector = "Иван Сергеевич",
                isCanSkypeOpen = false,
                isAdditionalLesson = false
            ),
            LessonInfo(
                lessonName = "Физкультура",
                beginTime = Calendar.getInstance().apply {
                    set(Calendar.YEAR, year)
                    set(Calendar.MONTH, month)
                    set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    set(Calendar.HOUR_OF_DAY, hourOfDay + 1)
                    set(Calendar.MINUTE, 0)
                    timeZone = TimeZone.getDefault()
                },
                durationMinutes = 60,
                isCanSkypeOpen = true,
                lector = "Глеб Алексеевич",
                isAdditionalLesson = false
            ),
            LessonInfo(
                lessonName = "Литература",
                beginTime = Calendar.getInstance().apply {
                    set(Calendar.YEAR, year)
                    set(Calendar.MONTH, month)
                    set(Calendar.DAY_OF_MONTH, dayOfMonth + 1)
                    set(Calendar.HOUR_OF_DAY, hourOfDay)
                    set(Calendar.MINUTE, 0)
                    timeZone = TimeZone.getDefault()
                },
                durationMinutes = 60,
                isCanSkypeOpen = true,
                lector = "Виктор Семенович",
                isAdditionalLesson = false
            ),
            LessonInfo(
                lessonName = "Физика",
                beginTime = Calendar.getInstance().apply {
                    set(Calendar.YEAR, year)
                    set(Calendar.MONTH, month)
                    set(Calendar.DAY_OF_MONTH, dayOfMonth + 1)
                    set(Calendar.HOUR_OF_DAY, hourOfDay + 1)
                    set(Calendar.MINUTE, 0)
                    timeZone = TimeZone.getDefault()
                },
                durationMinutes = 60,
                lector = "Вера Павловна",
                isCanSkypeOpen = false,
                isAdditionalLesson = true,
                description = "Дополнительная лекция по физике"
            )

        )
    }

    override suspend fun getHomeWorks(): List<HomeWorkInfo> {
        val today = Calendar.getInstance()
        val year = today.get(Calendar.YEAR)
        val month = today.get(Calendar.MONTH)
        val dayOfMonth = today.get(Calendar.DAY_OF_MONTH)
        val hourOfDay = today.get(Calendar.HOUR_OF_DAY)
        return listOf(
            HomeWorkInfo(
                lessonName = "История",
                description = "Прочитать параграф 5",
                deadline = Calendar.getInstance().apply {
                    set(Calendar.YEAR, year)
                    set(Calendar.MONTH, month)
                    set(Calendar.DAY_OF_MONTH, dayOfMonth + 5)
                    set(Calendar.HOUR_OF_DAY, hourOfDay)
                    set(Calendar.MINUTE, 0)
                    timeZone = TimeZone.getDefault()
                }
            ),
            HomeWorkInfo(
                lessonName = "Физика",
                description = "Прочитать параграф 6",
                deadline = Calendar.getInstance().apply {
                    set(Calendar.YEAR, year)
                    set(Calendar.MONTH, month)
                    set(Calendar.DAY_OF_MONTH, dayOfMonth + 6)
                    set(Calendar.HOUR_OF_DAY, hourOfDay)
                    set(Calendar.MINUTE, 0)
                    timeZone = TimeZone.getDefault()
                }
            ),
            HomeWorkInfo(
                lessonName = "Биология",
                description = "Прочитать параграф 7",
                deadline = Calendar.getInstance().apply {
                    set(Calendar.YEAR, year)
                    set(Calendar.MONTH, month)
                    set(Calendar.DAY_OF_MONTH, dayOfMonth + 7)
                    set(Calendar.HOUR_OF_DAY, hourOfDay)
                    set(Calendar.MINUTE, 0)
                    timeZone = TimeZone.getDefault()
                }
            ),
        )
    }
}
