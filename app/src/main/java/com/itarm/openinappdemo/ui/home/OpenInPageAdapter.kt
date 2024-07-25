package com.itarm.openinappdemo.ui.home

import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class OpenInPageAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    private val fragmentList: MutableList<Fragment> = ArrayList()
    private val fragmentTitleList: MutableList<String> = ArrayList()
    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    fun addFragment(fragment: Fragment?, title: String) {
        fragment?.let {
            fragmentList.add(fragment)
            fragmentTitleList.add(title)
        }
    }

    override fun saveState(): Parcelable? {
        return null
    }

    fun getOffScreenPageLimit() = fragmentList.size

    override fun restoreState(state: Parcelable?, loader: ClassLoader?) {
        try {
            super.restoreState(state, loader)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}