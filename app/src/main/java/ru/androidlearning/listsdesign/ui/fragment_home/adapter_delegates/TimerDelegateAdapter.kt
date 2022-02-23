package ru.androidlearning.listsdesign.ui.fragment_home.adapter_delegates

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import ru.androidlearning.listsdesign.databinding.ItemTimerBinding
import ru.androidlearning.listsdesign.ui.fragment_home.data.HomeItemDiff
import ru.androidlearning.listsdesign.ui.fragment_home.data.TimerItem

fun timerDelegate() = adapterDelegateViewBinding<TimerItem, HomeItemDiff, ItemTimerBinding>(
    viewBinding = { layoutInflater, root -> ItemTimerBinding.inflate(layoutInflater, root, false) }
) {
    bind {
        binding.itemTimerDd1Tv.text = item.timeUi.dd1.toString()
        binding.itemTimerDd2Tv.text = item.timeUi.dd2.toString()
        binding.itemTimerHh1Tv.text = item.timeUi.hh1.toString()
        binding.itemTimerHh2Tv.text = item.timeUi.hh2.toString()
        binding.itemTimerMm1Tv.text = item.timeUi.mm1.toString()
        binding.itemTimerMm2Tv.text = item.timeUi.mm2.toString()
    }
}
