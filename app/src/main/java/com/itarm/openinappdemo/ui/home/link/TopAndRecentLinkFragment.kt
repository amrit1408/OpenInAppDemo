package com.itarm.openinappdemo.ui.home.link

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.itarm.openinappdemo.databinding.FragmentTopAndRecentLinkBinding
import com.itarm.openinappdemo.model.LinkTabExtra
import com.itarm.openinappdemo.model.WebViewExtra
import com.itarm.openinappdemo.ui.web.WebViewActivity

class TopAndRecentLinkFragment : Fragment(), TopAndRecentCardVH.TopAndRecentListener {

    private lateinit var binding: FragmentTopAndRecentLinkBinding
    private var extra: LinkTabExtra? = null

    private lateinit var viewModel: TopAndRecentLinkViewModel
    private var adapter: TopAndRecentLinkAdapter? = null

    companion object {
        fun get(extra: LinkTabExtra): TopAndRecentLinkFragment {
            return TopAndRecentLinkFragment().apply {
                arguments = Bundle().apply { putParcelable(LinkTabExtra.extra_Key, extra) }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        arguments?.apply {
            getParcelable<LinkTabExtra>(LinkTabExtra.extra_Key)?.apply {
                extra = this
            }
        }
        binding = FragmentTopAndRecentLinkBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = TopAndRecentLinkViewModelFactory(extra)
        viewModel = ViewModelProvider(this, factory)[TopAndRecentLinkViewModel::class.java]
        viewModel.setListItemData()
        adapter = TopAndRecentLinkAdapter(this)
        binding.topAndRecentLinkRv.adapter = adapter
        val layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.topAndRecentLinkRv.layoutManager = layoutManager
        adapter?.updateData(viewModel.listItem)
        // binding.topAndRecentLinkRv.isNestedScrollingEnabled=false
    }

    override fun clickOnCard(url: String) {
        val intent = Intent(context, WebViewActivity::class.java)
        Log.e("clickOnCard", "clickOnCard: $url")
        intent.putExtra(WebViewExtra.extra_Key, WebViewExtra(url))
        startActivity(intent)
    }


}