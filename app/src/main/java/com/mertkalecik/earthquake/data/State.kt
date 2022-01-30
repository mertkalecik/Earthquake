package com.mertkalecik.earthquake.data

data class State<T: EarthquakeState>(
    val uiState: T,
    val error: Exception? = null
)
