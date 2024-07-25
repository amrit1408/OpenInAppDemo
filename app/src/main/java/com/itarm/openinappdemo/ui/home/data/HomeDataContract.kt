package com.itarm.openinappdemo.ui.home.data

import com.itarm.openinappdemo.model.HomeResponse
import com.itarm.openinappdemo.remote.EndPoints.dashboardNew
import retrofit2.Response
import retrofit2.http.GET

interface HomeDataContract {
    companion object {
        fun get(): HomeDataContract = HomeApiClient().getApiClient()
    }

    @GET(dashboardNew)
    suspend fun fetchHomeData():Response<HomeResponse>
}