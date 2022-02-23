package ru.androidlearning.listsdesign.model.stopwatch.calculator

import ru.androidlearning.listsdesign.model.stopwatch.provider.TimestampProvider
import ru.androidlearning.listsdesign.utils.ZERO_VALUE

class StopwatchCalculatorImpl(
    private val timestampProvider: TimestampProvider
) : StopwatchCalculator {

    override fun getRemainTimeMillis(examsTime: Long): Long {
        val currentTime = timestampProvider.getMilliseconds()
        val delta = examsTime - currentTime
        return if (delta < ZERO_VALUE) ZERO_VALUE.toLong()
        else delta
    }
}
