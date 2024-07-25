package com.itarm.openinappdemo.ui.home

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.itarm.openinappdemo.R
import com.itarm.openinappdemo.databinding.HomeBottomBarViewBinding
import com.itarm.openinappdemo.utils.layoutInflater

class HomeBottomView : LinearLayout, View.OnClickListener {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val binding: HomeBottomBarViewBinding by lazy {
        HomeBottomBarViewBinding.inflate(
            context.layoutInflater(),
            this,
            true
        )
    }

    private var selectedItem = HomeBottomBar.LINK
    private var bottomBarListener: HomeBottomBarInterface? = null

    init {
        binding.linkLl.setOnClickListener(this)
        binding.coursesLl.setOnClickListener(this)
        binding.campaignsLl.setOnClickListener(this)
        binding.profileLl.setOnClickListener(this)

        binding.linkLl.performClick()
    }

    fun selectedTab(bottom: HomeBottomBar) {
        resetBottomAppBarViews()
        selectedItem = bottom
        when (bottom) {
            HomeBottomBar.LINK -> {}
            HomeBottomBar.COURSES -> {}
            HomeBottomBar.CAMPAIGNS -> {}
            HomeBottomBar.PROFILE -> {}
        }
    }

    private fun resetBottomAppBarViews() {
        when (selectedItem) {
            HomeBottomBar.LINK -> {}
            HomeBottomBar.COURSES -> {}
            HomeBottomBar.CAMPAIGNS -> {}
            HomeBottomBar.PROFILE -> {}
        }
    }

    override fun onClick(view: View?) {
        resetBottomAppBarViews()
        var callListener = false
        val currentSelectedItem = selectedItem

        when (view?.id) {
            R.id.link_ll -> {
                selectedItem = HomeBottomBar.LINK
            }

            R.id.courses_ll -> {
                selectedItem = HomeBottomBar.COURSES
            }

            R.id.campaigns_ll -> {
                selectedItem = HomeBottomBar.CAMPAIGNS
            }

            R.id.profile_ll -> {
                selectedItem = HomeBottomBar.PROFILE
            }

        }

        if (currentSelectedItem != selectedItem) {
            callListener = true
        }

        if (callListener) {
            bottomBarListener?.onItemSelected(selectedItem, this, true)
        }

    }

    enum class HomeBottomBar {
        LINK, COURSES, CAMPAIGNS, PROFILE;

        val tag: Int
            get() = when (this) {
                LINK -> 0
                COURSES -> 1
                CAMPAIGNS -> 2
                PROFILE -> 3
            }
    }

    fun setOnItemSelectedListener(bottomBarInterface: HomeBottomBarInterface) {
        bottomBarListener = bottomBarInterface
    }

    interface HomeBottomBarInterface {
        fun onItemSelected(
            bottom: HomeBottomBar,
            bottomBarView: HomeBottomView,
            vibrate: Boolean
        ) {
            bottomBarView.selectedTab(bottom)
        }
    }
}