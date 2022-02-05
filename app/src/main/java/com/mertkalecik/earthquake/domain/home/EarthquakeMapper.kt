package com.mertkalecik.earthquake.domain.home

import com.mertkalecik.earthquake.base.Mapper
import com.mertkalecik.earthquake.data.home.EarthquakeModel
import com.mertkalecik.earthquake.data.home.EarthquakeUIModel
import com.mertkalecik.earthquake.data.response.EarthquakeResponse
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class EarthquakeMapper @Inject constructor() : Mapper<EarthquakeResponse, EarthquakeUIModel?> {

    override fun map(input: EarthquakeResponse) = with(input) {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault())

        EarthquakeUIModel(
            dataList = features?.map {
                EarthquakeModel(
                    magnitude = it.properties?.mag ?: 0.0,
                    title = it.properties?.title ?: "",
                    place = it.properties?.place ?: "",
                    date = dateFormat.format(Date(it.properties?.time ?: 0)),
                    latitude = it.geometry?.coordinates?.get(1) ?: 0.0,
                    longitude = it.geometry?.coordinates?.first() ?: 0.0
                )
            } ?: listOf()
        )
    }
}