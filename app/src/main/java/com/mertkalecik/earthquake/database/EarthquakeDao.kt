package com.mertkalecik.earthquake.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mertkalecik.earthquake.data.home.EarthquakeModel

@Dao
interface EarthquakeDao {
    @Query("SELECT * FROM tbl_earthquake")
    suspend fun getAll(): List<EarthquakeModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(list: List<EarthquakeModel>)

    @Query("DELETE FROM tbl_earthquake")
    suspend fun clear()
}