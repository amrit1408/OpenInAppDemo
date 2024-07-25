package com.itarm.openinappdemo.utils

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.LayoutInflater
import com.itarm.openinappdemo.app.AppControllerContract

val isConnected: Boolean
    get() {
        val connectivityManager =
            AppControllerContract.instance.properContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = connectivityManager.activeNetworkInfo
        return netInfo != null && netInfo.isConnected

    }

fun Context.layoutInflater(): LayoutInflater = LayoutInflater.from(this)

fun Context.vibrateDevice(duration: Long) {
    val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        getSystemService(Vibrator::class.java)
    } else null
    vibrator?.let {
        if (Build.VERSION.SDK_INT >= 26) {
            it.vibrate(VibrationEffect.createOneShot(duration, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            @Suppress("DEPRECATION")
            it.vibrate(duration)
        }
    }
}