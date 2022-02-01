package com.mertkalecik.earthquake

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.mertkalecik.earthquake.data.Event
import com.mertkalecik.earthquake.navigation.SetupNavGraph
import com.mertkalecik.earthquake.ui.home.HomeViewModel
import com.mertkalecik.earthquake.ui.theme.EarthquakeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EarthquakeTheme {
                val navController = rememberNavController()

                SetupNavGraph(navController = navController, ::observeEvent)

            }
        }
    }

    private fun observeEvent(event: Event) =
        when (event) {
            is HomeViewModel.HomeEvent.NavigateToHome -> Unit
            else -> Unit
        }
}