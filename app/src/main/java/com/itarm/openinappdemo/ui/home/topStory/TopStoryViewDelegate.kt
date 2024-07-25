package com.itarm.openinappdemo.ui.home.topStory

import android.view.ViewGroup
import com.itarm.openinappdemo.utils.BaseDelegate


class TopStoryViewDelegate : BaseDelegate() {
    override fun onCreateViewHolder(parent: ViewGroup) = TopStoryVH(parent)
}