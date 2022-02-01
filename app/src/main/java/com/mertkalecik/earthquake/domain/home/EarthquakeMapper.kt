package com.mertkalecik.earthquake.domain.home

import com.mertkalecik.earthquake.base.Mapper
import com.mertkalecik.earthquake.data.home.EarthquakeModel
import com.mertkalecik.earthquake.data.home.EarthquakeUIModel
import javax.inject.Inject

class EarthquakeMapper @Inject constructor() :
    Mapper<Unit, EarthquakeUIModel> {

    override fun map(input: Unit) = EarthquakeUIModel(
        listOf(
            EarthquakeModel(
                place = "Manisa"
            ),
            EarthquakeModel(
                place = "Izmir"
            ),
            EarthquakeModel(
                place = "Aydin"
            ),
            EarthquakeModel(
                place = "Ankara"
            ),
            EarthquakeModel(
                place = "Istanbul"
            ),
            EarthquakeModel(
                place = "Tekirdag"
            ),
            EarthquakeModel(
                place = "Van"
            ),
            EarthquakeModel(
                place = "Bitlis"
            ),
            EarthquakeModel(
                place = "Kars"
            )
        )
    )
}