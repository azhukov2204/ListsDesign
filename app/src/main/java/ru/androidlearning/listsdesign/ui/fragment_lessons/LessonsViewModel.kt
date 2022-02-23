package ru.androidlearning.listsdesign.ui.fragment_lessons

import kotlinx.coroutines.launch
import ru.androidlearning.listsdesign.core.BaseMVVMViewModel
import ru.androidlearning.listsdesign.domain.LessonInfo
import ru.androidlearning.listsdesign.model.lessons.LessonsRepository
import ru.androidlearning.listsdesign.ui.fragment_lessons.data.LessonAdditionalProgressItem
import ru.androidlearning.listsdesign.ui.fragment_lessons.data.LessonProgressItem
import ru.androidlearning.listsdesign.ui.fragment_lessons.data.LessonsProgressItemDiff
import java.util.*

class LessonsViewModel(
    private val lessonsRepository: LessonsRepository
) : BaseMVVMViewModel<List<LessonsProgressItemDiff>>() {

    fun getData() {
        coroutineScopeIO.launch {
            val items = lessonsRepository
                .getLessons()
                .sortedBy { it.beginTime }
            val nearestPosition = getNearestPosition(items)
            items.map { lessonInfo ->
                val newLessonInfo =
                    if (items.indexOf(lessonInfo) == nearestPosition) lessonInfo.copy(isNearestPosition = true)
                    else lessonInfo.copy(isNearestPosition = false)
                if (lessonInfo.isAdditionalLesson) {
                    LessonAdditionalProgressItem(newLessonInfo)
                } else {
                    LessonProgressItem(newLessonInfo)
                }
            }.let { dataLoadingLiveData.postValue(it) }
        }
    }

    private fun getNearestPosition(items: List<LessonInfo>): Int {
        val today = Calendar.getInstance()

        return items
            .sortedBy { it.beginTime }
            .firstOrNull() { it.beginTime.time.after(today.time) }
            ?.let {
                items.indexOf(it)
            }
            ?: items.lastIndex
    }
}
