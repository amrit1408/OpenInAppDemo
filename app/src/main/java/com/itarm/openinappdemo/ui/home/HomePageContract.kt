package com.itarm.openinappdemo.ui.home

import com.itarm.openinappdemo.model.HomeResponse
import com.itarm.openinappdemo.remote.ResultWrapper
import com.itarm.openinappdemo.ui.home.data.HomeDataStore
import com.itarm.openinappdemo.ui.home.data.HomeRepository

interface HomePageContract {

    companion object {
        fun get(dataStore: HomeDataStore): HomePageContract = HomeRepository(dataStore)
    }

    suspend fun fetchHomePageData(): ResultWrapper<HomeResponse>
}