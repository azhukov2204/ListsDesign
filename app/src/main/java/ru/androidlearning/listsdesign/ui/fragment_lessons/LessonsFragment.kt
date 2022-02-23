package ru.androidlearning.listsdesign.ui.fragment_lessons

import android.annotation.SuppressLint
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.androidlearning.listsdesign.R
import ru.androidlearning.listsdesign.core.BaseMVVMFragment
import ru.androidlearning.listsdesign.databinding.FragmentLessonsBinding
import ru.androidlearning.listsdesign.ui.fragment_lessons.adapter_delegates.lessonAdditionalProgressDelegate
import ru.androidlearning.listsdesign.ui.fragment_lessons.adapter_delegates.lessonProgressDelegate
import ru.androidlearning.listsdesign.ui.fragment_lessons.data.LessonsProgressItemDiff

class LessonsFragment : BaseMVVMFragment(R.layout.fragment_lessons) {

    private val viewModel: LessonsViewModel by viewModel()
    private val viewBinding: FragmentLessonsBinding by viewBinding(FragmentLessonsBinding::bind)

    private val lessonsProgressAdapter by lazy {
        ListDelegationAdapter(
            lessonProgressDelegate(),
            lessonAdditionalProgressDelegate()
        )
    }

    override fun initViews() {
        viewBinding.lessonsRv.adapter = lessonsProgressAdapter
    }

    override fun observeToLiveData() {
        viewModel.getLiveData().observe(viewLifecycleOwner) { lessonProgressItems ->
            render(lessonProgressItems)
        }
        viewModel.getData()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun render(lessonProgressItems: List<LessonsProgressItemDiff>?) {
        lessonsProgressAdapter.items = lessonProgressItems
        lessonsProgressAdapter.notifyDataSetChanged()
    }

    companion object {
        fun newInstance() = LessonsFragment()
    }
}
