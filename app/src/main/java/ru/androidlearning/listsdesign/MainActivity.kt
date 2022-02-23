package ru.androidlearning.listsdesign

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import org.koin.android.ext.android.inject
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.activityScope
import org.koin.core.scope.Scope
import ru.androidlearning.listsdesign.databinding.ActivityMainBinding
import ru.androidlearning.listsdesign.navigation.HomeFragmentScreen
import ru.androidlearning.listsdesign.navigation.LessonsFragmentScreen

class MainActivity : AppCompatActivity(R.layout.activity_main), AndroidScopeComponent {

    override val scope: Scope by activityScope()
    private val router: Router by inject()
    private val navigatorHolder: NavigatorHolder by inject()
    private val navigator by lazy { AppNavigator(this, R.id.main_container) }
    private val viewBinding: ActivityMainBinding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState ?: router.newRootScreen(HomeFragmentScreen)
        initBottomNavigationView()
    }

    private fun initBottomNavigationView() = with(viewBinding) {
        bottomNavigationView.addBubbleListener { id ->
            when (id) {
                R.id.home_fragment -> openHomeScreen()
                R.id.lessons_fragment -> openLessonsScreen()
            }
        }
    }

    private fun openHomeScreen(): Boolean {
        router.replaceScreen(HomeFragmentScreen)
        return true
    }

    private fun openLessonsScreen(): Boolean {
        router.replaceScreen(LessonsFragmentScreen)
        return true
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}
