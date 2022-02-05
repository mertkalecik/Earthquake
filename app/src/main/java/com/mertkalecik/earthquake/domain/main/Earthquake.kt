package com.mertkalecik.earthquake.domain.main

import com.mertkalecik.earthquake.base.UseCase
import com.mertkalecik.earthquake.base.mapWith
import com.mertkalecik.earthquake.data.home.EarthquakeUIModel
import com.mertkalecik.earthquake.database.EarthquakeRepository
import com.mertkalecik.earthquake.domain.home.EarthquakeMapper
import javax.inject.Inject

class Earthquake @Inject constructor(
    private val repository: EarthquakeRepository,
    private val mapper: EarthquakeMapper
) : UseCase<Earthquake.Params, EarthquakeUIModel?> {

    override suspend fun invoke(input: Params): EarthquakeUIModel? =
        repository.fetchEarthquakes(
            startDate = input.startDate,
            endDate = input.endDate
        ).body()?.mapWith(mapper)?.also { uiModel ->
            uiModel.dataList.let { repository.insertAll(it) }
        }

    data class Params(
        val startDate: String,
        val endDate: String
    )
}