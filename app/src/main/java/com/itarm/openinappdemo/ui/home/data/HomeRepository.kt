package com.itarm.openinappdemo.ui.home.data


import com.itarm.openinappdemo.ui.home.HomePageContract

class HomeRepository(private val dataStore: HomeDataStore) : HomePageContract {
    override suspend fun fetchHomePageData() = dataStore.fetchHomeData()
}