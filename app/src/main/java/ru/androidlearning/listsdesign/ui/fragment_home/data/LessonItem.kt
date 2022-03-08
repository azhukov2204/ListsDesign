package ru.androidlearning.listsdesign.ui.fragment_home.data

import ru.androidlearning.listsdesign.domain.LessonInfo

data class LessonItem(
    val lessonInfo: LessonInfo
) : LessonItemDiff {
    override val itemId: String
        get() = "$TAG${lessonInfo.hashCode()}"

    override val itemHash: Int
        get() = lessonInfo.hashCode()

    companion object {
        private const val TAG = "LessonItem"
    }
}
