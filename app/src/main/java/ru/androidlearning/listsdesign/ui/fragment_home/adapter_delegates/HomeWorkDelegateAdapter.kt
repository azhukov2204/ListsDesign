package ru.androidlearning.listsdesign.ui.fragment_home.adapter_delegates

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import ru.androidlearning.listsdesign.R
import ru.androidlearning.listsdesign.databinding.ItemHomeworkBinding
import ru.androidlearning.listsdesign.ui.fragment_home.data.HomeWorkItem
import ru.androidlearning.listsdesign.ui.fragment_home.data.HomeWorkItemDiff
import ru.androidlearning.listsdesign.utils.ZERO_VALUE
import java.util.*
import java.util.concurrent.TimeUnit

fun homeWorkDelegate() = adapterDelegateViewBinding<HomeWorkItem, HomeWorkItemDiff, ItemHomeworkBinding>(
    viewBinding = { layoutInflater, root -> ItemHomeworkBinding.inflate(layoutInflater, root, false) }
) {
    bind {
        with(binding) {
            itemHomeworkTitleTv.text = item.homeWorkInfo.lessonName
            itemHomeworkDescriptionTv.text = item.homeWorkInfo.description
            itemHomeworkRemainTv.text = getString(R.string.remain_days, getRemainDays(item.homeWorkInfo.deadline))
        }
    }
}

private fun getRemainDays(deadline: Calendar): Long {
    val deltaTime = deadline.timeInMillis - Calendar.getInstance().timeInMillis
    return if (deltaTime < ZERO_VALUE) ZERO_VALUE.toLong()
    else TimeUnit.DAYS.convert(deltaTime, TimeUnit.MILLISECONDS)
}
