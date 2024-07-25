package com.itarm.openinappdemo.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


data class HomeResponse(
    @SerializedName("applied_campaign")
    val appliedCampaign: Int,
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("extra_income")
    val extraIncome: Double,
    @SerializedName("links_created_today")
    val linksCreatedToday: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("startTime")
    val startTime: String,
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("statusCode")
    val statusCode: Int,
    @SerializedName("support_whatsapp_number")
    val supportWhatsappNumber: String,
    @SerializedName("today_clicks")
    val todayClicks: Int,
    @SerializedName("top_location")
    val topLocation: String,
    @SerializedName("top_source")
    val topSource: String,
    @SerializedName("total_clicks")
    val totalClicks: Int,
    @SerializedName("total_links")
    val totalLinks: Int
) {
    data class Data(
        @SerializedName("favourite_links")
        val favouriteLinks: List<Any>,
        @SerializedName("overall_url_chart")
        val overallUrlChart: OverallUrlChart,
        @SerializedName("recent_links")
        val recentLinks: List<Link>,
        @SerializedName("top_links")
        val topLinks: List<Link>
    ) {
        data class OverallUrlChart(
            @SerializedName("00:00")
            val x0000: Int,
            @SerializedName("01:00")
            val x0100: Int,
            @SerializedName("02:00")
            val x0200: Int,
            @SerializedName("03:00")
            val x0300: Int,
            @SerializedName("04:00")
            val x0400: Int,
            @SerializedName("05:00")
            val x0500: Int,
            @SerializedName("06:00")
            val x0600: Int,
            @SerializedName("07:00")
            val x0700: Int,
            @SerializedName("08:00")
            val x0800: Int,
            @SerializedName("09:00")
            val x0900: Int,
            @SerializedName("10:00")
            val x1000: Int,
            @SerializedName("11:00")
            val x1100: Int,
            @SerializedName("12:00")
            val x1200: Int,
            @SerializedName("13:00")
            val x1300: Int,
            @SerializedName("14:00")
            val x1400: Int,
            @SerializedName("15:00")
            val x1500: Int,
            @SerializedName("16:00")
            val x1600: Int,
            @SerializedName("17:00")
            val x1700: Int,
            @SerializedName("18:00")
            val x1800: Int,
            @SerializedName("19:00")
            val x1900: Int,
            @SerializedName("20:00")
            val x2000: Int,
            @SerializedName("21:00")
            val x2100: Int,
            @SerializedName("22:00")
            val x2200: Int,
            @SerializedName("23:00")
            val x2300: Int
        )

        @Parcelize
        data class Link(
            @SerializedName("app")
            val app: String,
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("domain_id")
            val domainId: String,
            @SerializedName("is_favourite")
            val isFavourite: Boolean,
            @SerializedName("original_image")
            val originalImage: String,
            @SerializedName("smart_link")
            val smartLink: String,
            @SerializedName("thumbnail")
            val thumbnail: String?,
            @SerializedName("times_ago")
            val timesAgo: String,
            @SerializedName("title")
            val title: String,
            @SerializedName("total_clicks")
            val totalClicks: Int,
            @SerializedName("url_id")
            val urlId: Int,
            @SerializedName("url_prefix")
            val urlPrefix: String?,
            @SerializedName("url_suffix")
            val urlSuffix: String,
            @SerializedName("web_link")
            val webLink: String
        ): Parcelable


    }
}