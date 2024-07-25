package com.itarm.openinappdemo.ui.home.link

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.ViewGroup
import com.itarm.openinappdemo.databinding.TopAndRecentLinkCardViewLayoutBinding
import com.itarm.openinappdemo.model.LinksDataItem
import com.itarm.openinappdemo.utils.BaseViewHolder
import com.itarm.openinappdemo.utils.DateUtils
import com.itarm.openinappdemo.utils.ImageLoader
import com.itarm.openinappdemo.utils.RecyclerViewListItem
import com.itarm.openinappdemo.utils.layoutInflater

class TopAndRecentCardVH(
    parent: ViewGroup,
    private val listener: TopAndRecentListener,
    private val binding: TopAndRecentLinkCardViewLayoutBinding = TopAndRecentLinkCardViewLayoutBinding.inflate(
        parent.context.layoutInflater(),
        parent,
        false
    )
) : BaseViewHolder(binding.root) {

    val mListener = listener
    override fun bindView(item: RecyclerViewListItem) {
        item as LinksDataItem

        itemView.apply {
//            var image: Bitmap? = null
//            val imageURL = item.imageUrl
//            try {
//                val `in` = java.net.URL(imageURL).openStream()
//                image = BitmapFactory.decodeStream(`in`)
//
//                handler.post {
//                    binding.imageIv.setImageBitmap(image)
//                }
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
            ImageLoader(binding.imageIv).execute(item.imageUrl)
            binding.titleTv.text = item.title
            binding.linkTv.text = item.linkUrl
            binding.numberOfClickTv.text = item.totalClicked
            binding.dateTv.text = DateUtils.changeDateFormat(item.createdAt)

            binding.topRecentCard.setOnClickListener { listener.clickOnCard(item.linkUrl) }
           // binding.copyUrlLl.setOnLongClickListener { listener.copyLink(item.linkUrl) }


        }
    }

    interface TopAndRecentListener {
        fun clickOnCard(url: String)
        //fun copyLink(url: String)
    }
}