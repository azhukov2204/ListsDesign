package ru.androidlearning.listsdesign.ui.fragment_home.adapter_delegates

import android.widget.Toast
import androidx.core.view.isVisible
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import ru.androidlearning.listsdesign.R
import ru.androidlearning.listsdesign.databinding.ItemLessonBinding
import ru.androidlearning.listsdesign.ui.fragment_home.data.LessonItem
import ru.androidlearning.listsdesign.ui.fragment_home.data.LessonItemDiff
import java.text.SimpleDateFormat
import java.util.*

fun lessonDelegate() = adapterDelegateViewBinding<LessonItem, LessonItemDiff, ItemLessonBinding>(
    viewBinding = { layoutInflater, root -> ItemLessonBinding.inflate(layoutInflater, root, false) }
) {
    val simpleTimeFormat = SimpleDateFormat(getString(R.string.time_format), Locale.getDefault())
    val simpleDateFormat = SimpleDateFormat(getString(R.string.date_format), Locale.getDefault())

    binding.itemLessonOpenSkypeBtn.setOnClickListener {
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
        binding.itemLessonTitleTv.text = item.lessonInfo.lessonName
        binding.itemLessonAdditionalInfoTv.text =
            getString(R.string.lessons_duration_format, formattedDate, formattedBeginTime, formattedEndTime)
        binding.itemLessonOpenSkypeBtn.isVisible = item.lessonInfo.isCanSkypeOpen
    }
}
