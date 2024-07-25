package com.itarm.openinappdemo.ui.home.data

import com.itarm.openinappdemo.remote.apiCall

class HomeDataStore(private val apiClient: HomeDataContract) {
    suspend fun fetchHomeData() = apiCall { apiClient.fetchHomeData()}
}