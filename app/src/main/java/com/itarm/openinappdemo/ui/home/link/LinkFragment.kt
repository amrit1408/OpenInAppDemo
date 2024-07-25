package com.itarm.openinappdemo.ui.home.link

import android.R.id.message
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.itarm.openinappdemo.databinding.FragmentLinkBinding
import com.itarm.openinappdemo.model.StandardizedError
import com.itarm.openinappdemo.ui.home.HomePageContract
import com.itarm.openinappdemo.ui.home.OpenInPageAdapter
import com.itarm.openinappdemo.ui.home.TabView
import com.itarm.openinappdemo.ui.home.data.HomeDataContract
import com.itarm.openinappdemo.ui.home.data.HomeDataStore
import com.itarm.openinappdemo.ui.home.topStory.TopStoryAdapter
import com.itarm.openinappdemo.utils.DataFetchState
import com.itarm.openinappdemo.utils.StateMachine


class LinkFragment : Fragment(), TabView.TabListener {

    private lateinit var binding: FragmentLinkBinding
    private var adapter: TopStoryAdapter? = null
    private lateinit var viewModel: LinkViewModel
    private val stateMachine = StateMachine()
    private val factory =
        LinkViewModelFactory(HomePageContract.get(HomeDataStore(HomeDataContract.get())))

    private var topLinkFragment: TopAndRecentLinkFragment? = null
    private var recentLinkFragment: TopAndRecentLinkFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, factory)[LinkViewModel::class.java]
        viewModel.loadApi(stateMachine)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLinkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = TopStoryAdapter()
        binding.topStoryRv.adapter = adapter
        val layoutManager = LinearLayoutManager(context, HORIZONTAL, false)
        binding.topStoryRv.layoutManager = layoutManager
        binding.tabView.setTabListener(this)
        stateMachine.observe(viewLifecycleOwner) {
            when (it) {
                is DataFetchState.Loading -> {
                    onApiLoading()
                }

                is DataFetchState.Success -> {
                    onApiSuccess()
                }

                is DataFetchState.Error -> {
                    onApiError(it.error)
                }

                else -> {

                }
            }
        }

    }

    private fun setViewPager() {
        topLinkFragment = TopAndRecentLinkFragment.get(viewModel.topListExtra())
        recentLinkFragment = TopAndRecentLinkFragment.get(viewModel.recentListExtra())

        val adapter = OpenInPageAdapter(childFragmentManager)
        adapter.addFragment(topLinkFragment, "")
        adapter.addFragment(recentLinkFragment, "")

        binding.linkTab.adapter = adapter
        binding.linkTab.post {
            binding.linkTab.setCurrentItem(TabView.Links.TOP_LINKS.tag, false)
            onSelectedTab(TabView.Links.TOP_LINKS, binding.tabView)
        }
    }

    override fun onSelectedTab(links: TabView.Links, tabView: TabView) {
        super.onSelectedTab(links, tabView)
        binding.linkTab.setCurrentItem(links.tag, false)
        when (links) {
            TabView.Links.TOP_LINKS -> {

            }

            TabView.Links.RECENT_LINK -> {

            }
        }
    }


    private fun onApiLoading() {
        binding.successView.visibility = View.GONE
        binding.errorTv.visibility = View.GONE
        binding.loading.visibility = View.VISIBLE
    }

    private fun onApiSuccess() {
        setViewPager()
        binding.errorTv.visibility = View.GONE
        binding.loading.visibility = View.GONE
        binding.successView.visibility = View.VISIBLE
        adapter?.updateData(viewModel.topStoryList)
        binding.whatsAppLl.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=+91${viewModel.whatsAapNumber}" + "&text=" + message))
            startActivity(intent)

        }

    }

    private fun onApiError(error: StandardizedError) {
        binding.loading.visibility = View.GONE
        binding.successView.visibility = View.GONE
        binding.errorTv.visibility = View.VISIBLE
        binding.errorTv.text = error.displayError
    }


}