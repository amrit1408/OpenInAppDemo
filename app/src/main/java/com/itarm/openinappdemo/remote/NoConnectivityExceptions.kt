package com.itarm.openinappdemo.remote

import com.itarm.openinappdemo.R
import com.itarm.openinappdemo.app.AppControllerContract
import com.itarm.openinappdemo.model.StandardizedError
import okio.IOException

const val NO_INTERNET_CONNECTION_CODE = 503
val NO_INTERNET_ERROR = NoConnectivityExceptions.standardError

object NoConnectivityExceptions : IOException() {
    override val message: String?
        get() = AppControllerContract.instance.properContext.getString(R.string.no_internet_connection)

    val standardError: StandardizedError = StandardizedError(
        responseCode = NO_INTERNET_CONNECTION_CODE,
        displayError = "Kindly make sure device is connected with internet access"
    )
}