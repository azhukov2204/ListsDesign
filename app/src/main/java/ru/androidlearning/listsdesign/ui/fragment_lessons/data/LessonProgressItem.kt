package ru.androidlearning.listsdesign.ui.fragment_lessons.data

import ru.androidlearning.listsdesign.domain.LessonInfo

data class LessonProgressItem(
    val lessonInfo: LessonInfo
): LessonsProgressItemDiff {
    override val itemId: String
        get() = "$TAG${lessonInfo.hashCode()}"

    override val itemHash: Int
        get() = lessonInfo.hashCode()

    companion object {
        private const val TAG = "LessonProgressItem"
    }
}
