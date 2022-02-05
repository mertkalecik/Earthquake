package com.mertkalecik.earthquake.ui.home

import com.mertkalecik.earthquake.base.BaseViewModel
import com.mertkalecik.earthquake.data.Event
import com.mertkalecik.earthquake.data.home.EarthquakeUIModel
import com.mertkalecik.earthquake.data.login.HomeState
import com.mertkalecik.earthquake.database.EarthquakeRepository
import com.mertkalecik.earthquake.domain.home.EarthquakeMapper
import com.mertkalecik.earthquake.exts.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val earthquakeRepository: EarthquakeRepository
) : BaseViewModel<HomeState, HomeViewModel.HomeEvent>(HomeState()) {

    init {
        launch {
            val out = earthquakeRepository.getAll()
            setState {
                copy(homeState = EarthquakeUIModel(out))
            }
        }
    }

    sealed class HomeEvent : Event {
        object NavigateToHome : HomeEvent()
    }
}
