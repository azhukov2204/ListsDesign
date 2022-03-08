package ru.androidlearning.listsdesign.di.modules

import org.koin.dsl.module
import ru.androidlearning.listsdesign.model.lessons.LessonsRepository
import ru.androidlearning.listsdesign.model.lessons.LessonsRepositoryImpl

val lessonsModule = module {
    factory<LessonsRepository> { LessonsRepositoryImpl() }
}
