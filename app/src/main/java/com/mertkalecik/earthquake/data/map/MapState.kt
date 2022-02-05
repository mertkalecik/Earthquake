package com.mertkalecik.earthquake.data.map

import com.mertkalecik.earthquake.data.EarthquakeState
import com.mertkalecik.earthquake.data.home.EarthquakeModel

data class MapState(
    val earthquakeList: List<EarthquakeModel>? = null
) : EarthquakeState
