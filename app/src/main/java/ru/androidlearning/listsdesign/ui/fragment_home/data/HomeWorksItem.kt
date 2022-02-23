package ru.androidlearning.listsdesign.ui.fragment_home.data

import ru.androidlearning.listsdesign.domain.HomeWorkInfo

data class HomeWorksItem(
    val homeWorks: List<HomeWorkInfo>
) : HomeItemDiff {

    override val itemId: String
        get() = TAG
    override val itemHash: Int
        get() = homeWorks.hashCode()

    companion object {
        private const val TAG = "HomeWorksItem"
    }
}
