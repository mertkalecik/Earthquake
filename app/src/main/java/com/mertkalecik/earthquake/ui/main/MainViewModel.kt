package com.mertkalecik.earthquake.ui.main

import com.mertkalecik.earthquake.base.BaseViewModel
import com.mertkalecik.earthquake.data.Event
import com.mertkalecik.earthquake.data.home.EarthquakeUIModel
import com.mertkalecik.earthquake.data.main.MainState
import com.mertkalecik.earthquake.domain.main.Earthquake
import com.mertkalecik.earthquake.exts.getRequestDate
import com.mertkalecik.earthquake.exts.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val earthquake: Earthquake
) : BaseViewModel<MainState, MainViewModel.MainEvent>(MainState()) {

    init {
        launch {
            val date = getRequestDate()
            val uiModel = earthquake(Earthquake.Params(date.first, date.second))
            uiModel?.let(::init)
        }
    }

    private fun init(uiModel: EarthquakeUIModel) {
        setState {
            copy(earthquakeUIModel = uiModel)
        }
    }

    sealed class MainEvent : Event
}