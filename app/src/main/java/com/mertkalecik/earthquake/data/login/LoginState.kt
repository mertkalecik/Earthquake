package com.mertkalecik.earthquake.data.login

import com.mertkalecik.earthquake.data.EarthquakeState
import com.mertkalecik.earthquake.data.home.EarthquakeUIModel

data class HomeState(val homeState: EarthquakeUIModel? = null) : EarthquakeState
