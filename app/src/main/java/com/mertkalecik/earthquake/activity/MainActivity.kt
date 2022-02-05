package com.mertkalecik.earthquake.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.mertkalecik.earthquake.data.Event
import com.mertkalecik.earthquake.ui.home.HomeViewModel
import com.mertkalecik.earthquake.ui.main.MainScreen
import com.mertkalecik.earthquake.ui.main.MainViewModel
import com.mertkalecik.earthquake.ui.theme.EarthquakeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EarthquakeTheme {
                val state = viewModel.getUIState()

                state.value.uiState.earthquakeUIModel?.dataList?.let {
                    MainScreen()
                }
            }
        }
    }
}