package com.mertkalecik.earthquake.database

import com.mertkalecik.earthquake.data.home.EarthquakeModel
import com.mertkalecik.earthquake.network.EarthquakeService
import javax.inject.Inject

class EarthquakeRepository @Inject constructor(
    private val remote: EarthquakeService,
    private val local: EarthquakeDao
) {
    suspend fun getAll() = local.getAll()

    suspend fun insertAll(list: List<EarthquakeModel>) = local.insert(list)

    suspend fun deleteAll() = local.clear()

    suspend fun fetchEarthquakes(startDate: String, endDate: String) =
        remote.getEarthquakes(startDate = startDate, endDate = endDate)
}