package com.itarm.openinappdemo.app

import android.content.Context
import java.lang.ref.WeakReference

class AppController : AppControllerContract {
    companion object {
        private var INSTANCE: AppController? = null
        private var context: WeakReference<Context>? = null
        private var mAppVersion: String? = null
        private var baseUrl: String = ""

        fun init(
            context: WeakReference<Context>,
            baseUrl: String,
            appVersion: String,
        ): AppController? {
            Companion.context = context
            Companion.baseUrl = baseUrl
            this.mAppVersion = appVersion
            this.INSTANCE = AppController()
            return INSTANCE
        }

        fun get(): AppController = INSTANCE ?: throw AppContextGoneException
    }

    object AppContextGoneException : Exception(
        "App context is null, try calling init function of the " +
                "implementing class"
    )

    private var mBaseUrl = "https://api.inopenapp.com"
    override var baseURL: String
        get() = mBaseUrl
        set(value) {
            mBaseUrl = value
        }
    override val basicAuthKey: String
        get() = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MjU5MjcsImlhdCI6MTY3NDU1MDQ1MH0.dCkW0ox8tbjJA2GgUx2UEwNlbTZ7Rr38PVFJevYcXFI"

    override val properContext: Context
        get() = context?.get() ?: throw AppContextGoneException
}