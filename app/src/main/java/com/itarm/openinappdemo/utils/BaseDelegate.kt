package com.itarm.openinappdemo.utils

abstract class BaseDelegate : DelegateInterface {

    private var baseViewHolder: BaseViewHolder? = null

    override fun init(baseVH: BaseViewHolder) {
        baseViewHolder = baseVH
    }

    override fun onBindViewHolder(holder: BaseViewHolder, item: RecyclerViewListItem) {
        baseViewHolder = holder
        baseViewHolder?.bindView(item)
    }

    override fun onDestroyViewHolder() {
        baseViewHolder?.onDestroy()
        baseViewHolder = null
    }

    override fun pause() {
        baseViewHolder?.pause()
    }

    override fun resume() {
        baseViewHolder?.resume()
    }
}