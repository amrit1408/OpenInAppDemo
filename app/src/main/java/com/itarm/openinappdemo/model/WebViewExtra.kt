package com.itarm.openinappdemo.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WebViewExtra(val url: String) : Parcelable {
    companion object {
        const val extra_Key = "web_view_extra_key"
    }
}
