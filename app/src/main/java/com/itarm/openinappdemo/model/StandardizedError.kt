package com.itarm.openinappdemo.model

data class StandardizedError(
    val responseCode: Int? = null,
    val developerError: String = "",
    var displayError: String = ""
) : Throwable(developerError)