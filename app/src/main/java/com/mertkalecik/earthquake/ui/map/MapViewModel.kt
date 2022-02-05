package com.mertkalecik.earthquake.ui.map

import com.mertkalecik.earthquake.base.BaseViewModel
import com.mertkalecik.earthquake.data.Event
import com.mertkalecik.earthquake.data.map.MapState
import com.mertkalecik.earthquake.database.EarthquakeRepository
import com.mertkalecik.earthquake.exts.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val repository: EarthquakeRepository
) : BaseViewModel<MapState, MapViewModel.MapEvent>(MapState()) {

    init {
        launch {
            val list = repository.getAll()

            setState {
                copy(earthquakeList = list)
            }
        }
    }

    interface MapEvent : Event
}