package ru.androidlearning.listsdesign.ui.fragment_home.adapter_delegates

import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import ru.androidlearning.listsdesign.databinding.ItemHomeworksBinding
import ru.androidlearning.listsdesign.ui.fragment_home.data.HomeItemDiff
import ru.androidlearning.listsdesign.ui.fragment_home.data.HomeWorkItem
import ru.androidlearning.listsdesign.ui.fragment_home.data.HomeWorksItem

private val homeWorksAdapter by lazy {
    ListDelegationAdapter(
        homeWorkDelegate()
    )
}

fun homeWorksDelegate() = adapterDelegateViewBinding<HomeWorksItem, HomeItemDiff, ItemHomeworksBinding>(
    viewBinding = { layoutInflater, root -> ItemHomeworksBinding.inflate(layoutInflater, root, false) }
) {
    binding.itemHomeworksTitleRv.adapter = homeWorksAdapter
    val snapHelper: SnapHelper = LinearSnapHelper()
    snapHelper.attachToRecyclerView(binding.itemHomeworksTitleRv)

    bind {
        homeWorksAdapter.items = item.homeWorks.map { homeWorkInfo ->
            HomeWorkItem(
                homeWorkInfo = homeWorkInfo
            )
        }
    }
}
