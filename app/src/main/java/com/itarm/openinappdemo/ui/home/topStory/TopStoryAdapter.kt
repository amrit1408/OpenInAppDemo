package com.itarm.openinappdemo.ui.home.topStory

import com.itarm.openinappdemo.utils.BaseAdapter
import com.itarm.openinappdemo.utils.CardConstant

class TopStoryAdapter() : BaseAdapter() {
    init {
        initDelegates()
    }

    private fun initDelegates() {
        delegates[CardConstant.TOP_STORY_VIEW] = TopStoryViewDelegate()
    }
}

