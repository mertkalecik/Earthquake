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
import androidx.lifecycle.Lifecycle.Event.*
import androidx.lifecycle.LifecycleEventObserver
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.mertkalecik.earthquake.base.EqSimpleToolbar

@Composable
fun MapScreen() {
    Map()
}

@Composable
fun Map() {
    Column {
        EqSimpleToolbar(title = "Map")
        MapView()
    }
}

@Composable
fun MapView() {
    val context = LocalContext.current
    val mapView = remember { MapView(context) }

    val lifecycle = LocalLifecycleOwner.current.lifecycle
    lifecycle.addObserver(rememberMapLifeCycle(map = mapView))

    AndroidView(
        factory = {
            mapView.apply {
                getMapAsync { googleMap ->
                    googleMap.uiSettings.isZoomControlsEnabled = true
                    googleMap.addMarker(
                        MarkerOptions().position(
                            LatLng(41.0082, 28.9784)
                        )
                    )
                    googleMap.addMarker(
                        MarkerOptions().position(
                            LatLng(39.9333, 32.8597)
                        )
                    )
                    googleMap.moveCamera(
                        CameraUpdateFactory.newLatLngZoom(
                            LatLng(39.9333, 32.8597), 5F
                        )
                    )
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