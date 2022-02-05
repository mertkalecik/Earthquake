package com.mertkalecik.earthquake.domain.detail

import com.mertkalecik.earthquake.base.UseCase
import com.mertkalecik.earthquake.data.home.EarthquakeModel
import com.mertkalecik.earthquake.database.EarthquakeRepository
import javax.inject.Inject

class FindEarthquake @Inject constructor(
    private val repository: EarthquakeRepository
) : UseCase<FindEarthquake.Params, EarthquakeModel> {

    override suspend fun invoke(input: Params) =
        repository.getEarthquake(input.earthquakeId)

    data class Params(
        val earthquakeId: Long
    )
}