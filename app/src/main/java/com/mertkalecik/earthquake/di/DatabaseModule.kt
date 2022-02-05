package com.mertkalecik.earthquake.di

import android.content.Context
import androidx.room.Room
import com.mertkalecik.earthquake.database.EarthquakeDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        EarthquakeDB::class.java,
        "eq_db"
    ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideDao(db:EarthquakeDB) = db.dao()
}