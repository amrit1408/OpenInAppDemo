package com.itarm.openinappdemo.ui.home

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.itarm.openinappdemo.R
import com.itarm.openinappdemo.databinding.TabLayoutViewBinding
import com.itarm.openinappdemo.utils.layoutInflater

class TabView : LinearLayout, View.OnClickListener {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private var selectedItem = Links.TOP_LINKS
    private var listener: TabListener? = null


    private val binding: TabLayoutViewBinding by lazy {
        TabLayoutViewBinding.inflate(
            context.layoutInflater(),
            this,
            true
        )
    }

    init {
        binding.topLinksTab.setOnClickListener(this)
        binding.recentLinksTab.setOnClickListener(this)
    }

    fun setTabListener(tabListener: TabListener) {
        listener = tabListener
    }

    fun removeTabListener() {
        listener = null
    }

    fun selectedTab(link: Links) {
        resetTab()
        selectedItem = link
        when (link) {
            Links.TOP_LINKS -> {
                binding.topLinksTab.setBackgroundResource(R.drawable.selected_tab_bg)
                binding.topLinksTab.setTextColor(resources.getColor(R.color.white))
            }

            Links.RECENT_LINK -> {
                binding.recentLinksTab.setBackgroundResource(R.drawable.selected_tab_bg)
                binding.recentLinksTab.setTextColor(resources.getColor(R.color.white))
            }
        }
    }

    private fun resetTab() {
        when (selectedItem) {
            Links.TOP_LINKS -> {
                binding.topLinksTab.background = null
                binding.topLinksTab.setTextColor(resources.getColor(R.color.gray_999CA0))
            }

            Links.RECENT_LINK -> {
                binding.recentLinksTab.background = null
                binding.recentLinksTab.setTextColor(resources.getColor(R.color.gray_999CA0))
            }
        }
    }


    override fun onClick(view: View?) {
        resetTab()
        var callListener = false
        val currentSelectedItem = selectedItem

        when (view?.id) {
            R.id.top_links_tab -> {
                selectedItem = Links.TOP_LINKS
            }

            R.id.recent_links_tab -> {
                selectedItem = Links.RECENT_LINK
            }
        }

        if (currentSelectedItem != selectedItem) {
            callListener = true
        }

        if (callListener) {
            listener?.onSelectedTab(selectedItem, this)
        }

    }

    enum class Links {
        TOP_LINKS, RECENT_LINK;

        val tag: Int
            get() = when (this) {
                TOP_LINKS -> 0
                RECENT_LINK -> 1
            }
    }

    interface TabListener {
        fun onSelectedTab(links: Links, tabView: TabView) {
            tabView.selectedTab(links)
        }
    }
}