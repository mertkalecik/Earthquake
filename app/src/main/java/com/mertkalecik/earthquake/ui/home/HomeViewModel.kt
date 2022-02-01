package com.mertkalecik.earthquake.ui.home

import com.mertkalecik.earthquake.base.BaseViewModel
import com.mertkalecik.earthquake.data.Event
import com.mertkalecik.earthquake.data.login.HomeState
import com.mertkalecik.earthquake.domain.home.EarthquakeMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val mapper: EarthquakeMapper
) : BaseViewModel<HomeState, HomeViewModel.HomeEvent>(HomeState()) {

    fun init() {
        val out = mapper.map(Unit)

        setState {
            copy(homeState = out)
        }
    }

    sealed class HomeEvent : Event {
        object NavigateToHome : HomeEvent()
    }
}
