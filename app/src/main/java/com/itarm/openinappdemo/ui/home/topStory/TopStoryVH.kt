package com.itarm.openinappdemo.ui.home.topStory

import android.view.ViewGroup
import com.itarm.openinappdemo.databinding.TopStoryViewLayoutBinding
import com.itarm.openinappdemo.model.TopStoryItem
import com.itarm.openinappdemo.utils.BaseViewHolder
import com.itarm.openinappdemo.utils.RecyclerViewListItem
import com.itarm.openinappdemo.utils.layoutInflater

class TopStoryVH(
    parent: ViewGroup,
    private val binding: TopStoryViewLayoutBinding = TopStoryViewLayoutBinding.inflate(
        parent.context.layoutInflater(),
        parent,
        false
    )
) : BaseViewHolder(binding.root) {
    override fun bindView(item: RecyclerViewListItem) {
        item as TopStoryItem
        itemView.apply {
            binding.logoView.background = resources.getDrawable(item.logo)
            binding.titleTv.text = item.title
            binding.subTitleTv.text = item.subTitle
        }
    }
}