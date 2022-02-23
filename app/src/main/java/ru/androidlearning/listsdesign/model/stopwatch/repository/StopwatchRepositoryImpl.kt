package ru.androidlearning.listsdesign.model.stopwatch.repository

import ru.androidlearning.listsdesign.model.stopwatch.calculator.StopwatchCalculator
import java.util.*

class StopwatchRepositoryImpl(
    private val stopwatchCalculator: StopwatchCalculator
) : StopwatchRepository {

    override fun getRemainTimeMillis(): Long {
        return stopwatchCalculator.getRemainTimeMillis(EXAMS_DATE.timeInMillis)
    }

    companion object {
        //Дата экзамана:
        private val EXAMS_DATE = Calendar.getInstance().apply {
            set(Calendar.YEAR, 2022)
            set(Calendar.MONTH, 3)
            set(Calendar.DAY_OF_MONTH, 7)
            set(Calendar.HOUR_OF_DAY, 10)
            set(Calendar.MINUTE, 30)
            timeZone = TimeZone.getDefault()
        }
    }
}
