package com.mertkalecik.earthquake.data.home

data class EarthquakeModel(
    val magnitude: Double = 0.0,
    val depth: Double = 0.0,
    val place: String,
    val date: String = ""
)
