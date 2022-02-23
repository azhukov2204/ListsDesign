package ru.androidlearning.listsdesign.ui.fragment_home.data

import ru.androidlearning.listsdesign.domain.HomeWorkInfo

data class HomeWorkItem(
    val homeWorkInfo: HomeWorkInfo
) : HomeWorkItemDiff {
    override val itemId: String
        get() = "$TAG${homeWorkInfo.lessonName}${homeWorkInfo.deadline}"
    override val itemHash: Int
        get() = homeWorkInfo.hashCode()

    companion object {
        private const val TAG = "HomeWorkItem"
    }
}
