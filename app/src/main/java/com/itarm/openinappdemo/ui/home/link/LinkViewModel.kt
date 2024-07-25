package com.itarm.openinappdemo.ui.home.link

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itarm.openinappdemo.R
import com.itarm.openinappdemo.model.HomeResponse
import com.itarm.openinappdemo.model.LinkTabExtra
import com.itarm.openinappdemo.model.TopStoryItem
import com.itarm.openinappdemo.remote.ResultWrapper
import com.itarm.openinappdemo.ui.home.HomePageContract
import com.itarm.openinappdemo.utils.RecyclerViewListItem
import com.itarm.openinappdemo.utils.StateMachine
import com.itarm.openinappdemo.utils.onApiError
import com.itarm.openinappdemo.utils.onApiLoading
import com.itarm.openinappdemo.utils.onApiSuccess
import kotlinx.coroutines.launch

class LinkViewModel(private val repository: HomePageContract?) : ViewModel() {

    val topStoryList = mutableListOf<RecyclerViewListItem>()
    private var topLinkList: List<HomeResponse.Data.Link?>? = null
    private var recentLinkList: List<HomeResponse.Data.Link?>? = null
     var whatsAapNumber: String? = ""


    fun loadApi(stateMachine: StateMachine) {
        stateMachine.onApiLoading()
        viewModelScope.launch {
            when (val request = repository?.fetchHomePageData()) {
                is ResultWrapper.Success -> {
                    val result = request.value
                    topStoryList.add(
                        TopStoryItem(
                            logo = R.drawable.ic_click,
                            title = result.todayClicks.toString(),
                            subTitle = "Toady's click"
                        )
                    )

                    topStoryList.add(
                        TopStoryItem(
                            logo = R.drawable.ic_location,
                            title = result.topLocation,
                            subTitle = "Top Locations"
                        )
                    )

                    topStoryList.add(
                        TopStoryItem(
                            logo = R.drawable.ic_global,
                            title = result.topSource,
                            subTitle = "Top Sources"
                        )
                    )

                    topLinkList = result.data.topLinks
                    recentLinkList = result.data.recentLinks
                    whatsAapNumber = result.supportWhatsappNumber
                    stateMachine.onApiSuccess()
                }

                is ResultWrapper.Error -> {
                    stateMachine.onApiError(request.error)
                }

                else -> {}
            }

        }
    }

    fun topListExtra() = LinkTabExtra(topLinkList)

    fun recentListExtra() = LinkTabExtra(recentLinkList)
}