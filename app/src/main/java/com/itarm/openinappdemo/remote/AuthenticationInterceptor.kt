package com.itarm.openinappdemo.remote

import com.itarm.openinappdemo.app.AppControllerContract
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.net.UnknownHostException

class AuthenticationInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        return try {
            val auth = AppControllerContract.instance.basicAuthKey
            var request = chain.request()
            val requestBuilder = request.newBuilder()
                .header("Authorization", auth)
            request = requestBuilder.build()
            val response = chain.proceed(request)
            response
        } catch (e: UnknownHostException) {
            throw IOException(e)
        }
    }
}