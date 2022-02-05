package com.mertkalecik.earthquake.network

import com.mertkalecik.earthquake.data.response.EarthquakeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EarthquakeService {
    @GET("fdsnws/event/1/query?format=geojson")
    suspend fun getEarthquakes(
        @Query("starttime") startDate: String,
        @Query("endtime") endDate: String,
        @Query("limit") limit: String = "200",
        @Query("minmagnitude") min: Double = 0.0
    ): Response<EarthquakeResponse>
}