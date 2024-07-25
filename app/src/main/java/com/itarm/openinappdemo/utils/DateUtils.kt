package com.itarm.openinappdemo.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

object DateUtils {
    private const val FORMAT_DD_MMM_YYYY = "d MMM yyyy"
    fun changeDateFormat(date: String): String? {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        inputFormat.timeZone = TimeZone.getTimeZone("UTC")
        val date: Date? = inputFormat.parse(date)
        val outputFormat = SimpleDateFormat(FORMAT_DD_MMM_YYYY, Locale.getDefault())
        return date?.let { outputFormat.format(it) }
    }
}