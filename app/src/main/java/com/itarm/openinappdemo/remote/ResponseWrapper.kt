package com.itarm.openinappdemo.remote

import com.google.gson.Gson
import com.itarm.openinappdemo.model.ErrorResponse
import com.itarm.openinappdemo.model.StandardizedError
import retrofit2.Response
import java.io.IOException
import java.net.UnknownHostException

suspend fun <T : Any> apiCall(call: suspend () -> Response<T>): ResultWrapper<T> {
    return try {
        val response = call.invoke()
        if (response.isSuccessful) {
            if (response.body() != null) {
                ResultWrapper.Success(response.body()!!, response.raw())
            } else {
                ResultWrapper.Error(
                    StandardizedError(
                        responseCode = response.code(),
                        displayError = "No Data Found"
                    )
                )
            }
        } else {
            try {
                val errorObj =
                    Gson().fromJson(response.errorBody()?.charStream(), ErrorResponse::class.java)
                ResultWrapper.Error(
                    StandardizedError(
                        responseCode = errorObj.statusCode,
                        displayError = errorObj.message
                    )
                )
            } catch (e: Exception) {
                e.printStackTrace()
                ResultWrapper.Error(
                    StandardizedError(
                        responseCode = response.code(),
                        displayError = "Try Again Later"
                    )
                )
            }
        }

    } catch (e: Exception) {
        e.printStackTrace()
        when (e) {
            is NoConnectivityExceptions -> {
                ResultWrapper.Error(e.standardError)
            }

            is UnknownHostException -> {
                ResultWrapper.Error(NO_INTERNET_ERROR)
            }

            is IOException -> {
                ResultWrapper.Error(NO_INTERNET_ERROR)
            }

            else -> {
                ResultWrapper.Error(StandardizedError(displayError = "Something went wrong"))
            }
        }
    }
}