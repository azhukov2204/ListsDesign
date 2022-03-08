package ru.androidlearning.listsdesign.ui.fragment_home.data

import java.util.concurrent.TimeUnit

data class TimerItem(
    val remainTime: Long
) : HomeItemDiff {
    override val itemId: String
        get() = TAG

    override val itemHash: Int
        get() = timeUi.hashCode()

    val timeUi: TimeUi = convertLongToTime()

    private fun convertLongToTime(): TimeUi {
        val daysFull = TimeUnit.DAYS.convert(remainTime, TimeUnit.MILLISECONDS)
        val hoursFull = TimeUnit.HOURS.convert(remainTime, TimeUnit.MILLISECONDS)
        val minutesFull = TimeUnit.MINUTES.convert(remainTime, TimeUnit.MILLISECONDS)
        val hours = hoursFull - daysFull * HOURS_PER_DAY
        val minutes = minutesFull - hoursFull * MINUTES_PER_HOUR
        return TimeUi(
            dd1 = daysFull.toString().padStart(TIME_UNIT_LENGTH, PADDING_CHAR).first(),
            dd2 = daysFull.toString().padStart(TIME_UNIT_LENGTH, PADDING_CHAR).second(),
            hh1 = hours.toString().padStart(TIME_UNIT_LENGTH, PADDING_CHAR).first(),
            hh2 = hours.toString().padStart(TIME_UNIT_LENGTH, PADDING_CHAR).second(),
            mm1 = minutes.toString().padStart(TIME_UNIT_LENGTH, PADDING_CHAR).first(),
            mm2 = minutes.toString().padStart(TIME_UNIT_LENGTH, PADDING_CHAR).second()
        )
    }

    private fun CharSequence.second(): Char {
        return if (length < TIME_UNIT_LENGTH) PADDING_CHAR
        else this[1]
    }

    data class TimeUi(
        val dd1: Char,
        val dd2: Char,
        val hh1: Char,
        val hh2: Char,
        val mm1: Char,
        val mm2: Char
    )

    companion object {
        private const val TAG = "TimerItem"
        private const val PADDING_CHAR = '0'
        private const val HOURS_PER_DAY = 24
        private const val MINUTES_PER_HOUR = 60
        private const val TIME_UNIT_LENGTH = 2
    }
}
