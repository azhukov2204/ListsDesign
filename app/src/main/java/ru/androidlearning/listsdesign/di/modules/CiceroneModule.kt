package ru.androidlearning.listsdesign.di.modules

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.androidlearning.listsdesign.MainActivity

val ciceroneModule = module {
    val cicerone: Cicerone<Router> = Cicerone.create()
    single { cicerone.router }
    scope(named<MainActivity>()) {
        scoped { cicerone.getNavigatorHolder() }
    }
}
