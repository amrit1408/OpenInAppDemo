package com.itarm.openinappdemo.model

import android.os.Parcelable
import com.itarm.openinappdemo.utils.CardConstant
import com.itarm.openinappdemo.utils.RecyclerViewListItem
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue


@Parcelize
data class LinkTabExtra(val link: @RawValue List<HomeResponse.Data.Link?>?) : Parcelable {
    companion object {
        const val extra_Key = "link_tab_extra"
    }
}

data class LinksDataItem(
    val title: String,
    val imageUrl: String,
    val totalClicked: String,
    val createdAt: String,
    val linkUrl: String
) : RecyclerViewListItem {
    override fun getViewType() = CardConstant.LINK_LIST_CARD_VIEW

    override fun getUnique() = this

}
