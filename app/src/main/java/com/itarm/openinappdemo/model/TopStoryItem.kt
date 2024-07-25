package com.itarm.openinappdemo.model

import com.itarm.openinappdemo.utils.CardConstant
import com.itarm.openinappdemo.utils.RecyclerViewListItem

data class TopStoryItem(
    val logo: Int,
    val title: String,
    val subTitle: String
) :
    RecyclerViewListItem {
    override fun getViewType() = CardConstant.TOP_STORY_VIEW
    override fun getUnique() = this
}
