package com.mertkalecik.earthquake.ui.detail

import com.mertkalecik.earthquake.base.BaseViewModel
import com.mertkalecik.earthquake.data.Event
import com.mertkalecik.earthquake.data.detail.DetailState
import com.mertkalecik.earthquake.data.home.EarthquakeModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor()
    : BaseViewModel<DetailState, DetailViewModel.DetailEvent>(DetailState()) {

    fun setState(earthquakeModel: EarthquakeModel) {
        setState {
            copy(earthquakeModel = earthquakeModel)
        }
    }

    sealed class DetailEvent: Event
}