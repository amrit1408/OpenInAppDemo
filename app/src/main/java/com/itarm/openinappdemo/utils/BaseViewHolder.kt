package com.itarm.openinappdemo.utils

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bindView(item: RecyclerViewListItem)
    open fun onDestroy() {}
    open fun pause() {}
    open fun resume() {}
}