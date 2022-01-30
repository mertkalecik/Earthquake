package com.mertkalecik.earthquake.exts

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

@OptIn(InternalCoroutinesApi::class)
fun <T> Flow<T>.collectIn(
    owner: LifecycleOwner,
    minActiveState: Lifecycle.State = Lifecycle.State.STARTED,
    action: suspend CoroutineScope.(T) -> Unit = {}
) = owner.addRepeatingJob(minActiveState) {
    collect { action(it) }
}

public fun LifecycleOwner.addRepeatingJob(
    state: Lifecycle.State,
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
    block: suspend CoroutineScope.() -> Unit
): Job = lifecycleScope.launch(coroutineContext) {
    lifecycle.repeatOnLifecycle(state, block)
}