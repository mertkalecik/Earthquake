package com.mertkalecik.earthquake.ui.detail

import com.mertkalecik.earthquake.base.BaseViewModel
import com.mertkalecik.earthquake.data.Event
import com.mertkalecik.earthquake.data.detail.DetailState
import com.mertkalecik.earthquake.domain.detail.FindEarthquake
import com.mertkalecik.earthquake.exts.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val findEarthquake: FindEarthquake
) : BaseViewModel<DetailState, DetailViewModel.DetailEvent>(DetailState()) {

    fun init(id: Long) {
        launch {
            val model = findEarthquake(FindEarthquake.Params(earthquakeId = id))
            setState {
                copy(earthquakeModel = model)
            }
        }
    }
    
    sealed class DetailEvent : Event
}