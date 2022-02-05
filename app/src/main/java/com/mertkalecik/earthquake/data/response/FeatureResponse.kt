package com.mertkalecik.earthquake.data.response

import com.google.gson.annotations.SerializedName

data class FeatureResponse(
    @SerializedName("properties")
    val properties: Feature?,

    @SerializedName("geometry")
    val geometry: Geometry?
)