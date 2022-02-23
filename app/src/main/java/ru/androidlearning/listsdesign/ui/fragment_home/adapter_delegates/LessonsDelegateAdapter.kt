package ru.androidlearning.listsdesign.ui.fragment_home.adapter_delegates

import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import ru.androidlearning.listsdesign.R
import ru.androidlearning.listsdesign.databinding.ItemLessonsBinding
import ru.androidlearning.listsdesign.ui.fragment_home.data.HomeItemDiff
import ru.androidlearning.listsdesign.ui.fragment_home.data.LessonItem
import ru.androidlearning.listsdesign.ui.fragment_home.data.LessonsItem
import ru.androidlearning.listsdesign.utils.ONE_VALUE
import ru.androidlearning.listsdesign.utils.ZERO_VALUE
import java.util.*

private val lessonsAdapter by lazy {
    ListDelegationAdapter(
        lessonDelegate()
    )
}

fun lessonsDelegate() = adapterDelegateViewBinding<LessonsItem, HomeItemDiff, ItemLessonsBinding>(
    viewBinding = { layoutInflater, root -> ItemLessonsBinding.inflate(layoutInflater, root, false) }
) {

    binding.itemLessonsRv.adapter = lessonsAdapter
    val snapHelper: SnapHelper = LinearSnapHelper()
    snapHelper.attachToRecyclerView(binding.itemLessonsRv)

    bind {
        val lessonsCount = getTodayLessonsCount(item)
        binding.itemLessonsCountTv.text = context.getString(R.string.classes_count, lessonsCount.toString())
        lessonsAdapter.items = item.lessons.map { lessonInfo ->
            LessonItem(
                lessonInfo = lessonInfo
            )
        }.sortedBy { it.lessonInfo.beginTime }
        binding.itemLessonsRv.scrollToPosition(getNearestPosition(item))
    }
}

private fun getTodayLessonsCount(item: LessonsItem): Int {
    val today = Calendar.getInstance().apply {
        set(Calendar.HOUR_OF_DAY, ZERO_VALUE)
        set(Calendar.MINUTE, ZERO_VALUE)
        set(Calendar.SECOND, ZERO_VALUE)
    }
    val todayDate = today.time
    val tomorrowDate = today.apply {
        add(Calendar.DATE, ONE_VALUE)
    }.time

    return item.lessons.filter { lessonInfo ->
        lessonInfo.beginTime.time.after(todayDate) && lessonInfo.beginTime.time.before(tomorrowDate)
    }.count()
}

private fun getNearestPosition(item: LessonsItem): Int {
    val today = Calendar.getInstance()
    return item.lessons
        .sortedBy { it.beginTime }
        .firstOrNull { it.beginTime.time.after(today.time) }
        ?.let {
            item.lessons.indexOf(it)
        }
        ?: item.lessons.lastIndex
}
