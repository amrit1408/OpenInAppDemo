package com.itarm.openinappdemo.utils

interface RecyclerViewListItem {
    fun getViewType(): Int
    fun getUnique(): Any
}