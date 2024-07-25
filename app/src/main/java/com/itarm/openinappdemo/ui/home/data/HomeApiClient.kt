package com.itarm.openinappdemo.ui.home.data

import com.itarm.openinappdemo.remote.BaseApiClient

class HomeApiClient : BaseApiClient<HomeDataContract>(HomeDataContract::class.java)