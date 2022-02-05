package com.mertkalecik.earthquake.data.response

import com.google.gson.annotations.SerializedName

data class Geometry(
    @SerializedName("coordinates")
    val coordinates: List<Double>?
)
