package com.mertkalecik.earthquake.ui.map

import android.os.Bundle
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle.Event.*
import androidx.lifecycle.LifecycleEventObserver
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.mertkalecik.earthquake.base.EqSimpleToolbar
import com.mertkalecik.earthquake.data.home.EarthquakeModel

@Composable
fun MapScreen(
    viewModel: MapViewModel = hiltViewModel()
) {
    val state = viewModel.getUIState()

    state.value.uiState.earthquakeList?.let {
        Map(it)
    }
}

@Composable
fun Map(
    list: List<EarthquakeModel>
) {
    Column {
        EqSimpleToolbar(title = "Map")
        MapView(list = list)
    }
}

@Composable
fun MapView(list: List<EarthquakeModel>) {
    val context = LocalContext.current
    val mapView = remember { MapView(context) }

    val lifecycle = LocalLifecycleOwner.current.lifecycle
    lifecycle.addObserver(rememberMapLifeCycle(map = mapView))

    AndroidView(
        factory = {
            mapView.apply {
                getMapAsync { googleMap ->
                    googleMap.uiSettings.isZoomControlsEnabled = true
                    list.let {
                        it.forEach { model ->
                            googleMap.addMarker(
                                MarkerOptions().position(
                                    LatLng(model.latitude, model.longitude)
                                )
                            )
                        }
                        it.first().let { coordinates ->
                            googleMap.moveCamera(
                                CameraUpdateFactory.newLatLngZoom(
                                    LatLng(coordinates.latitude, coordinates.longitude), 3F
                                )
                            )
                        }
                    }
                }
            }
        },
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 56.dp)
    )
}

@Composable
fun rememberMapLifeCycle(map: MapView): LifecycleEventObserver = remember {
    LifecycleEventObserver { _, event ->
        when (event) {
            ON_CREATE -> map.onCreate(Bundle())
            ON_START -> map.onStart()
            ON_RESUME -> map.onResume()
            ON_PAUSE -> map.onPause()
            ON_STOP -> map.onStop()
            ON_DESTROY -> map.onDestroy()
            ON_ANY -> throw IllegalStateException()
        }
    }
}