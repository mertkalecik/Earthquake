package com.mertkalecik.earthquake.data.response

import com.google.gson.annotations.SerializedName

data class EarthquakeResponse(
    @SerializedName("features")
    val features: List<FeatureResponse>?
)
