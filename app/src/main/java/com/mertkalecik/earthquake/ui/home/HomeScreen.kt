package com.mertkalecik.earthquake.ui.home

import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mertkalecik.earthquake.base.EqToolbar
import com.mertkalecik.earthquake.data.Event
import com.mertkalecik.earthquake.data.home.EarthquakeUIModel
import com.mertkalecik.earthquake.navigation.Screen
import com.mertkalecik.earthquake.ui.theme.Purple700

@Composable
fun HomeScreen(
    onEvent: (Event) -> Unit,
    navHostController: NavHostController
) {
    Home(onEvent = onEvent, navHostController = navHostController)
}

@Composable
fun Home(
    onEvent: (Event) -> Unit,
    navHostController: NavHostController
) {
    EqToolbar(
        title = "Earthquakes",
        backIconClick = {
            Log.d("Mert", "Back Button Clicked")
        }
    )
    FillEarthquake(onEvent = onEvent)
    DrawButton(navHostController = navHostController)
}

@Composable
fun FillEarthquake(
    viewModel: HomeViewModel = hiltViewModel(),
    onEvent: (Event) -> Unit
) {
    viewModel.init()
    val state = viewModel.getUIState()

    onEvent(HomeViewModel.HomeEvent.NavigateToHome)

    state.value.uiState.homeState?.let {
        DrawEarthquakes(uiModel = it)
    }
}

@Composable
fun DrawEarthquakes(
    uiModel: EarthquakeUIModel
) {
    LazyColumn(
        Modifier.padding(vertical = 56.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = uiModel.dataList,
            itemContent = {
                Text(text = it.place, Modifier.fillMaxSize())
                Divider(color = Color.Black)
            }
        )
    }
}

@Composable
fun DrawButton(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { navHostController.navigate(Screen.Detail.route) },
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Purple700,
                contentColor = Color.White
            )
        ) {
            Text("Detail")
        }
    }
}

@Composable
fun LoadWebUrl(url: String) {
    //val url = "https://github.com/mertkalecik"
    AndroidView(
        factory = {
            WebView(it).apply {
                webViewClient = WebViewClient()

                loadUrl(url)
            }
        },
        modifier = Modifier.padding(top = 56.dp)
    )
}

