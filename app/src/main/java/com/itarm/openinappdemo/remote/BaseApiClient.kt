package com.itarm.openinappdemo.remote

import com.itarm.openinappdemo.app.AppControllerContract
import retrofit2.Retrofit

abstract class BaseApiClient<T>(private val classT: Class<T>) {

    open fun getApiClient(): T {
        val baseUrl = AppControllerContract.instance.baseURL
        val client = ApiClientUtil.getOkHttpClient()
        val converter = ApiClientUtil.getConverter()

        val builder = Retrofit.Builder().apply {
            this.baseUrl(baseUrl)
            this.client(client)
            this.addConverterFactory(converter)
        }

        val retrofit = builder.build()
        return retrofit.create(classT)
    }
}