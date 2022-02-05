package com.mertkalecik.earthquake.data.detail

import com.mertkalecik.earthquake.data.EarthquakeState
import com.mertkalecik.earthquake.data.home.EarthquakeModel

data class DetailState(
    val earthquakeModel: EarthquakeModel? = null
) : EarthquakeState