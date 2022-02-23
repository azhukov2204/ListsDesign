package ru.androidlearning.listsdesign.ui.fragment_lessons.adapter_delegates

import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import ru.androidlearning.listsdesign.R
import ru.androidlearning.listsdesign.databinding.ItemLessonProgressBinding
import ru.androidlearning.listsdesign.ui.fragment_lessons.data.LessonProgressItem
import ru.androidlearning.listsdesign.ui.fragment_lessons.data.LessonsProgressItemDiff
import java.text.SimpleDateFormat
import java.util.*

fun lessonProgressDelegate() =
    adapterDelegateViewBinding<LessonProgressItem, LessonsProgressItemDiff, ItemLessonProgressBinding>(
        viewBinding = { layoutInflater, root -> ItemLessonProgressBinding.inflate(layoutInflater, root, false) }
    ) {
        val simpleTimeFormat = SimpleDateFormat(getString(R.string.time_format), Locale.getDefault())
        val simpleDateFormat = SimpleDateFormat(getString(R.string.date_format), Locale.getDefault())

        binding.itemLessonProgressIncludedLayout.itemLessonOpenSkypeBtn.setOnClickListener {
            context.packageManager
                .getLaunchIntentForPackage(getString(R.string.skype_package_name))
                ?.let { intent -> context.startActivity(intent) }
                ?: Toast.makeText(context, getString(R.string.skype_not_found), Toast.LENGTH_SHORT).show()
        }

        bind {
            val lessonCalendar = item.lessonInfo.beginTime
            val formattedDate = simpleDateFormat.format(lessonCalendar.time)
            val formattedBeginTime = simpleTimeFormat.format(item.lessonInfo.beginTime.time)
            lessonCalendar.apply {
                add(Calendar.MINUTE, item.lessonInfo.durationMinutes)
            }
            val formattedEndTime = simpleTimeFormat.format(lessonCalendar.time)

            binding.itemLessonProgressIncludedLayout.itemLessonTitleTv.text = item.lessonInfo.lessonName
            binding.itemLessonProgressTimeTv.text =
                getString(R.string.lessons_duration_format, formattedDate, formattedBeginTime, formattedEndTime)
            binding.itemLessonProgressIncludedLayout.itemLessonOpenSkypeBtn.isVisible = item.lessonInfo.isCanSkypeOpen
            binding.itemLessonProgressIncludedLayout.itemLessonAdditionalInfoTv.text = item.lessonInfo.lector
            binding.itemLessonProgressIv.isActivated = item.lessonInfo.isNearestPosition
            binding.itemLessonProgressAdditionalView.isGone = (bindingAdapterPosition == 0)
        }
    }
