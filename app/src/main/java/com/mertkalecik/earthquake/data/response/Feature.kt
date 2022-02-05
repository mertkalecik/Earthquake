package com.mertkalecik.earthquake.data.response

import com.google.gson.annotations.SerializedName

data class Feature(
    @SerializedName("mag")
    val mag: Double?,

    @SerializedName("place")
    val place: String?,

    @SerializedName("time")
    val time: Long?,

    @SerializedName("title")
    val title: String?
)
