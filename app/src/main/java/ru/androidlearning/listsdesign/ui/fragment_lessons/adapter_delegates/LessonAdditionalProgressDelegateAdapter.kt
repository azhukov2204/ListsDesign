package ru.androidlearning.listsdesign.ui.fragment_lessons.adapter_delegates

import androidx.core.view.isGone
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import ru.androidlearning.listsdesign.R
import ru.androidlearning.listsdesign.databinding.ItemLessonAdditionalProgressBinding
import ru.androidlearning.listsdesign.ui.fragment_lessons.data.LessonAdditionalProgressItem
import ru.androidlearning.listsdesign.ui.fragment_lessons.data.LessonsProgressItemDiff
import java.text.SimpleDateFormat
import java.util.*

fun lessonAdditionalProgressDelegate() =
    adapterDelegateViewBinding<LessonAdditionalProgressItem, LessonsProgressItemDiff, ItemLessonAdditionalProgressBinding>(
        viewBinding = { layoutInflater, root ->
            ItemLessonAdditionalProgressBinding.inflate(layoutInflater, root, false)
        }
    ) {
        val simpleTimeFormat = SimpleDateFormat(getString(R.string.time_format), Locale.getDefault())
        val simpleDateFormat = SimpleDateFormat(getString(R.string.date_format), Locale.getDefault())

        bind {
            val lessonCalendar = item.lessonInfo.beginTime
            val formattedDate = simpleDateFormat.format(lessonCalendar.time)
            val formattedBeginTime = simpleTimeFormat.format(item.lessonInfo.beginTime.time)
            lessonCalendar.apply {
                add(Calendar.MINUTE, item.lessonInfo.durationMinutes)
            }
            val formattedEndTime = simpleTimeFormat.format(lessonCalendar.time)

            binding.itemLessonProgressAdditionalTitleTv.text = item.lessonInfo.lessonName
            binding.itemLessonProgressAdditionalTimeTv.text =
                getString(R.string.lessons_duration_format, formattedDate, formattedBeginTime, formattedEndTime)
            binding.itemLessonProgressAdditionalInfoTv.text = item.lessonInfo.lector
            binding.itemLessonProgressAdditionalIv.isActivated = item.lessonInfo.isNearestPosition
            binding.itemLessonProgressAdditionalView.isGone = (bindingAdapterPosition == 0)
            binding.itemLessonProgressAdditionalDescriptionTv.text = item.lessonInfo.description
        }
    }
