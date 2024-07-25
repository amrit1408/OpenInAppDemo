package com.itarm.openinappdemo.utils

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter : RecyclerView.Adapter<BaseViewHolder>() {
    protected var items: MutableList<RecyclerViewListItem> = mutableListOf()
    private var viewGroup: ViewGroup? = null
    protected var delegates = HashMap<Int, DelegateInterface>()

    override fun getItemCount(): Int {
        return items.size
    }

    fun getItemAt(position: Int): RecyclerViewListItem? {
        if(items.isNotEmpty()) {
            return items[position]
        }
        return null
    }

    fun clearData() {
        items.clear()
        notifyDataSetChanged()
    }

    fun updateData(newItems: MutableList<RecyclerViewListItem>?, useDiffUtil: Boolean = true) {
        if (useDiffUtil) {
            newItems?.let {
                val diffResult = DiffUtil.calculateDiff(BaseDiffUtils(this.items, it))
                this.items.clear()
                this.items.addAll(newItems)
                diffResult.dispatchUpdatesTo(this)
            }
        } else {
            newItems?.let {
                this.items.clear()
                this.items.addAll(newItems)
            }
            notifyDataSetChanged()
        }
    }

    fun updateItems(index: Int, newItems: MutableList<RecyclerViewListItem>?) {
        newItems?.let {
            this.items.clear()
            this.items.addAll(newItems)
        }
        notifyItemChanged(index)
    }

    fun insertItem(index: Int, item: RecyclerViewListItem) {
        this.items.add(index, item)
        notifyItemInserted(index)
    }

    override fun getItemViewType(position: Int) = items[position].getViewType()

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        delegates[getItemViewType(position)]?.onBindViewHolder(holder, items[position])
    }

    open fun destroy() {
        try {
            val delegateInterfaces = delegates.values
            if (delegateInterfaces.isNotEmpty()) {
                delegateInterfaces.forEach { delegateInterface ->
                    delegateInterface.onDestroyViewHolder()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun resume() {
        try {
            val delegateInterface = delegates.values
            if (delegateInterface.isNotEmpty()) {
                delegateInterface.forEach { dI ->
                    dI.resume()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        viewGroup = parent
        return try {
            parent.clearFocus()
            viewGroup?.clearFocus()
            val bv = delegates[viewType]?.onCreateViewHolder(parent)!!
            delegates[viewType]?.init(bv)
            bv
        } catch (e: Exception) {
            e.printStackTrace()
            throw NoDelegateFoundException(viewType, this::class.java.simpleName)
        }
    }
}