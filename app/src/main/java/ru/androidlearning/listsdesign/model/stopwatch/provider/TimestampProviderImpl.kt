package ru.androidlearning.listsdesign.model.stopwatch.provider

class TimestampProviderImpl : TimestampProvider {
    override fun getMilliseconds(): Long =
        System.currentTimeMillis()
}
