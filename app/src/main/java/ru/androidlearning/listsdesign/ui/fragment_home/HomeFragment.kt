package ru.androidlearning.listsdesign.ui.fragment_home

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.androidlearning.listsdesign.R
import ru.androidlearning.listsdesign.core.BaseMVVMFragment
import ru.androidlearning.listsdesign.databinding.FragmentHomeBinding
import ru.androidlearning.listsdesign.ui.fragment_home.data.HomeDiffCallback
import ru.androidlearning.listsdesign.ui.fragment_home.data.HomeItemDiff
import ru.androidlearning.listsdesign.ui.fragment_home.adapter_delegates.homeWorksDelegate
import ru.androidlearning.listsdesign.ui.fragment_home.adapter_delegates.lessonsDelegate
import ru.androidlearning.listsdesign.ui.fragment_home.adapter_delegates.timerDelegate

class HomeFragment : BaseMVVMFragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModel()
    private val viewBinding: FragmentHomeBinding by viewBinding(FragmentHomeBinding::bind)

    private val homeAdapter by lazy {
        AsyncListDifferDelegationAdapter(
            HomeDiffCallback,
            timerDelegate(),
            lessonsDelegate(),
            homeWorksDelegate()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        savedInstanceState ?: viewModel.startStopwatch()
    }

    override fun initViews() {
        viewBinding.homeRv.adapter = homeAdapter
    }

    override fun observeToLiveData() {
        viewModel.getLiveData().observe(viewLifecycleOwner) { homeItems ->
            render(homeItems)
        }
    }

    private fun render(homeItem: List<HomeItemDiff>) {
        homeAdapter.items = homeItem
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}
