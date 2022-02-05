package com.mertkalecik.earthquake.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mertkalecik.earthquake.data.home.EarthquakeModel

@Database(
    entities = [EarthquakeModel::class],
    version = 2,
    exportSchema = false
)
abstract class EarthquakeDB : RoomDatabase() {
    abstract fun dao(): EarthquakeDao

    companion object {
        private var INSTANCE: EarthquakeDB? = null

        fun getInstance(context: Context): EarthquakeDB {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        EarthquakeDB::class.java,
                        "earthquake_db"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}