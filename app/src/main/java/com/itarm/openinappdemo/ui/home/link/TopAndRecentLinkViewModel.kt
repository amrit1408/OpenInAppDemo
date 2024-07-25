package com.itarm.openinappdemo.ui.home.link

import androidx.lifecycle.ViewModel
import com.itarm.openinappdemo.model.LinkTabExtra
import com.itarm.openinappdemo.model.LinksDataItem
import com.itarm.openinappdemo.utils.RecyclerViewListItem

class TopAndRecentLinkViewModel(private val extra: LinkTabExtra) : ViewModel() {
    private val list = extra.link
    var listItem = mutableListOf<RecyclerViewListItem>()

    fun setListItemData() {
        list?.forEach {
            listItem.add(
                LinksDataItem(
                    it?.title ?: "",
                    it?.originalImage ?: "",
                    it?.totalClicks.toString() ?: "",
                    it?.createdAt ?: "",
                    it?.webLink ?: ""
                )
            )
        }
    }

}