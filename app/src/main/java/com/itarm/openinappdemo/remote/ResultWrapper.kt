package com.itarm.openinappdemo.remote

import com.itarm.openinappdemo.model.StandardizedError
import okhttp3.Response

sealed class ResultWrapper<out T : Any> {

    data class Success<out T : Any>(val value: T, override var response: Response? = null) :
        ResultWrapper<T>(), ResponseResult {
        override fun toString() = "Result.Ok{value=$value, response=$response}"
    }

    data class Error(val error: StandardizedError) : ResultWrapper<Nothing>() {}
}

interface ResponseResult {
    var response: Response?
}