package com.itarm.openinappdemo.remote

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory

object ApiClientUtil {
    fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(getInternetInterceptor())
            .addInterceptor(AuthenticationInterceptor())
            .build()
    }

    private fun getLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private fun getInternetInterceptor(): Interceptor {
        return NetworkConnectionInterceptor()
    }

    fun getConverter(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    private fun provideGsonBuilder(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }
}