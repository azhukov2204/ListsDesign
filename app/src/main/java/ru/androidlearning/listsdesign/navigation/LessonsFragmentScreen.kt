package ru.androidlearning.listsdesign.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.androidlearning.listsdesign.ui.fragment_lessons.LessonsFragment

object LessonsFragmentScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        LessonsFragment.newInstance()
}
