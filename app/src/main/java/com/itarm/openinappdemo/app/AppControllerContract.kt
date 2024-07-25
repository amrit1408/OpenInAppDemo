package com.itarm.openinappdemo.app

import android.content.Context

interface AppControllerContract {
    companion object {
        val instance: AppControllerContract = AppController.get()
    }

    var baseURL: String
    val basicAuthKey: String
    val properContext: Context
}