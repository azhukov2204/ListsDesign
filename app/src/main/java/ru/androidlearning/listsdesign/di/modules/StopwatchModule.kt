package ru.androidlearning.listsdesign.di.modules

import org.koin.dsl.module
import ru.androidlearning.listsdesign.model.stopwatch.calculator.StopwatchCalculator
import ru.androidlearning.listsdesign.model.stopwatch.calculator.StopwatchCalculatorImpl
import ru.androidlearning.listsdesign.model.stopwatch.provider.TimestampProvider
import ru.androidlearning.listsdesign.model.stopwatch.provider.TimestampProviderImpl
import ru.androidlearning.listsdesign.model.stopwatch.repository.StopwatchRepository
import ru.androidlearning.listsdesign.model.stopwatch.repository.StopwatchRepositoryImpl

val stopwatchModule = module {
    factory<TimestampProvider> { TimestampProviderImpl() }
    factory<StopwatchCalculator> { StopwatchCalculatorImpl(timestampProvider = get()) }
    factory<StopwatchRepository> { StopwatchRepositoryImpl(stopwatchCalculator = get()) }
}
