package com.itarm.openinappdemo.ui.home.link

import android.view.ViewGroup
import com.itarm.openinappdemo.utils.BaseDelegate


class TopAndRecentLinkDelegate(private val listener: TopAndRecentCardVH.TopAndRecentListener,) : BaseDelegate() {
    override fun onCreateViewHolder(parent: ViewGroup) = TopAndRecentCardVH(parent,listener)
}