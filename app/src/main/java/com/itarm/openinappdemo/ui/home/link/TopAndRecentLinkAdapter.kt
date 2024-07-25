package com.itarm.openinappdemo.ui.home.link

import com.itarm.openinappdemo.utils.BaseAdapter
import com.itarm.openinappdemo.utils.CardConstant

class TopAndRecentLinkAdapter(private val listener: TopAndRecentCardVH.TopAndRecentListener,) : BaseAdapter() {
    init {
        initDelegate()
    }

    private fun initDelegate() {
        delegates[CardConstant.LINK_LIST_CARD_VIEW] = TopAndRecentLinkDelegate(listener)
    }
}