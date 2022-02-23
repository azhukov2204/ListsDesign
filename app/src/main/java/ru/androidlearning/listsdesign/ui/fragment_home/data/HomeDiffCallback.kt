package ru.androidlearning.listsdesign.ui.fragment_home.data

import androidx.recyclerview.widget.DiffUtil

object HomeDiffCallback : DiffUtil.ItemCallback<HomeItemDiff>() {
    override fun areItemsTheSame(oldItem: HomeItemDiff, newItem: HomeItemDiff): Boolean {
        return oldItem.itemId == newItem.itemId
    }

    override fun areContentsTheSame(oldItem: HomeItemDiff, newItem: HomeItemDiff): Boolean {
        return oldItem.itemHash == newItem.itemHash
    }
}
