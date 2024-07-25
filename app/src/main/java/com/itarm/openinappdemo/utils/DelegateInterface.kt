package com.itarm.openinappdemo.utils

import android.view.ViewGroup

interface DelegateInterface {
    fun init(baseVH: BaseViewHolder)
    fun onCreateViewHolder(parent: ViewGroup): BaseViewHolder
    fun onBindViewHolder(holder: BaseViewHolder, item: RecyclerViewListItem)
    fun onDestroyViewHolder()
    fun pause()
    fun resume()
}