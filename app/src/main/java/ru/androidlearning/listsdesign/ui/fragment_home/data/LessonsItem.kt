package ru.androidlearning.listsdesign.ui.fragment_home.data

import ru.androidlearning.listsdesign.domain.LessonInfo

data class LessonsItem(
    val lessons: List<LessonInfo>
) : HomeItemDiff {

    override val itemId: String
        get() = TAG

    override val itemHash: Int
        get() = lessons.hashCode()

    companion object {
        private const val TAG = "LessonsItem"
    }
}
