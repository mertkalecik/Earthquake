package com.mertkalecik.earthquake.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mertkalecik.earthquake.data.Event
import com.mertkalecik.earthquake.data.EarthquakeState
import com.mertkalecik.earthquake.data.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

abstract class BaseViewModel<S: EarthquakeState, E: Event> constructor(initialState: S) : ViewModel() {

    private val stateMutex = Mutex()
    private val eventMutex = Mutex()

    // State Flows
    private val _stateFlow = MutableStateFlow(State(initialState))
    private val stateFlow: StateFlow<State<S>> get() = _stateFlow
    // Current State
    private val currentSate: S get() = _stateFlow.value.uiState

    @Composable
    fun getUIState() = stateFlow.collectAsState()

    protected fun setState(reducer: S.() -> S) {
        pushState {
            val newState = _stateFlow.value.copy(uiState = reducer(currentSate))
            _stateFlow.value = newState
        }
    }

    private fun pushState(action: () -> Unit) = viewModelScope.launch {
        stateMutex.withLock {
            action.invoke()
        }
    }
}