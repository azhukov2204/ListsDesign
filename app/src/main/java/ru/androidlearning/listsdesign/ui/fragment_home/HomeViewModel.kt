package ru.androidlearning.listsdesign.ui.fragment_home

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.androidlearning.listsdesign.core.BaseMVVMViewModel
import ru.androidlearning.listsdesign.model.lessons.LessonsRepository
import ru.androidlearning.listsdesign.model.stopwatch.repository.StopwatchRepository
import ru.androidlearning.listsdesign.ui.fragment_home.data.HomeItemDiff
import ru.androidlearning.listsdesign.ui.fragment_home.data.HomeWorksItem
import ru.androidlearning.listsdesign.ui.fragment_home.data.LessonsItem
import ru.androidlearning.listsdesign.ui.fragment_home.data.TimerItem

class HomeViewModel(
    private val stopwatchRepository: StopwatchRepository,
    private val lessonsRepository: LessonsRepository
) : BaseMVVMViewModel<List<HomeItemDiff>>() {

    fun startStopwatch() {
        coroutineScopeIO.launch {
            val lessons = lessonsRepository.getLessons()
            val homeWorks = lessonsRepository.getHomeWorks()
            while (true) {
                val resultTime = stopwatchRepository.getRemainTimeMillis()
                listOf(
                    TimerItem(resultTime),
                    LessonsItem(lessons),
                    HomeWorksItem(homeWorks)
                ).let { dataLoadingLiveData.postValue(it) }
                delay(DEFAULT_DELAY_MS)
            }
        }
    }

    companion object {
        private const val DEFAULT_DELAY_MS = 500L
    }
}
