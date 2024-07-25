package com.itarm.openinappdemo.ui.home.link

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.itarm.openinappdemo.model.LinkTabExtra
import com.itarm.openinappdemo.ui.home.HomePageContract

class LinkViewModelFactory(val data: HomePageContract) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LinkViewModel(data) as T
    }
}

class TopAndRecentLinkViewModelFactory(val data: LinkTabExtra?) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TopAndRecentLinkViewModel(data!!) as T
    }
}
