package ru.androidlearning.listsdesign.di.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.androidlearning.listsdesign.ui.fragment_lessons.LessonsFragment
import ru.androidlearning.listsdesign.ui.fragment_lessons.LessonsViewModel

val lessonsViewModelModule = module {
    scope(named<LessonsFragment>()) {
        viewModel { LessonsViewModel(lessonsRepository = get()) }
    }
}
