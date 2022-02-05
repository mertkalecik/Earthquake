package com.mertkalecik.earthquake.exts

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.mertkalecik.earthquake.base.BaseViewModel
import kotlinx.coroutines.launch

fun BaseViewModel<*, *>.launch(
    onError: (ex: Exception) -> Unit = {},
    onCompleted: () -> Unit = {},
    block: suspend () -> Unit = {}
) = viewModelScope.launch {
    try {
        block()
    } catch (ex: Exception) {
        onError(ex)
        Log.d("Error", ex.stackTraceToString())
    } finally {
        onCompleted()
    }
}