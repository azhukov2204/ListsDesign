package ru.androidlearning.listsdesign.model.stopwatch.repository

interface StopwatchRepository {
    fun getRemainTimeMillis(): Long
}
