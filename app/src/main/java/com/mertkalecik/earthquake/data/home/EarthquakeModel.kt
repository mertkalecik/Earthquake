package com.mertkalecik.earthquake.data.home

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_earthquake")
data class EarthquakeModel(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,

    @ColumnInfo(name = "magnitude")
    val magnitude: Double = 0.0,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "place")
    val place: String,

    @ColumnInfo(name = "date")
    val date: String = "",

    @ColumnInfo(name = "latitude")
    val latitude: Double,

    @ColumnInfo(name = "longitude")
    val longitude: Double
)
