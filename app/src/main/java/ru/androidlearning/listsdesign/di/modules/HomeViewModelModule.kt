package ru.androidlearning.listsdesign.di.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.androidlearning.listsdesign.ui.fragment_home.HomeFragment
import ru.androidlearning.listsdesign.ui.fragment_home.HomeViewModel

val homeViewModelModule = module {
    scope(named<HomeFragment>()) {
        viewModel {
            HomeViewModel(
                stopwatchRepository = get(),
                lessonsRepository = get()
            )
        }
    }
}
