package com.itarm.openinappdemo.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.itarm.openinappdemo.databinding.ActivityHomeBinding
import com.itarm.openinappdemo.ui.home.link.LinkFragment
import com.itarm.openinappdemo.utils.vibrateDevice


class HomeActivity : AppCompatActivity(), HomeBottomView.HomeBottomBarInterface {
    private val binding: ActivityHomeBinding by lazy { ActivityHomeBinding.inflate(layoutInflater) }

    private var linkFragment: LinkFragment? = null
    private var coursesFragment: CoursesFragment? = null
    private var campaignsFragment: CampaignsFragment? = null
    private var profileFragment: ProfileFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.bottomBar.setOnItemSelectedListener(this)
        init()
    }

    private fun init() {
        setViewPager()
    }

    private fun setViewPager() {
        linkFragment = LinkFragment()
        coursesFragment = CoursesFragment()
        campaignsFragment = CampaignsFragment()
        profileFragment = ProfileFragment()

        val adapter = OpenInPageAdapter(supportFragmentManager)
        adapter.addFragment(linkFragment, "")
        adapter.addFragment(coursesFragment, "")
        adapter.addFragment(campaignsFragment, "")
        adapter.addFragment(profileFragment, "")

        binding.viewPager.isSaveEnabled = false
        binding.viewPager.adapter = adapter

        binding.viewPager.post {
            binding.viewPager.setCurrentItem(HomeBottomView.HomeBottomBar.LINK.tag, false)
            onItemSelected(HomeBottomView.HomeBottomBar.LINK, binding.bottomBar, false)
        }
    }

    override fun onItemSelected(
        bottom: HomeBottomView.HomeBottomBar,
        bottomBarView: HomeBottomView,
        vibrate: Boolean
    ) {
        super.onItemSelected(bottom, bottomBarView, vibrate)
        binding.viewPager.setCurrentItem(bottom.tag, false)
        if (vibrate) vibrateDevice(15)
    }
}