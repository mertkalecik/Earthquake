package com.mertkalecik.earthquake.data.main

import com.mertkalecik.earthquake.data.EarthquakeState
import com.mertkalecik.earthquake.data.home.EarthquakeUIModel

data class MainState(
    val earthquakeUIModel: EarthquakeUIModel? = null
) : EarthquakeState