package com.mertkalecik.earthquake

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.mertkalecik.earthquake.navigation.SetupNavGraph
import com.mertkalecik.earthquake.ui.home.HomeViewModel
import com.mertkalecik.earthquake.ui.theme.EarthquakeTheme

class MainActivity : ComponentActivity() {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EarthquakeTheme {
                val navController = rememberNavController()
                SetupNavGraph(navController = navController)
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    //Greeting(viewModel = viewModel)
                    //LoadWebUrl(context = this, url = "https://github.com/mertkalecik")
                }
            }
        }
    }
}

@Composable
fun Greeting(viewModel: HomeViewModel) {
    val loginState by viewModel.getUIState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello ${loginState.uiState.loginState?.tmp}!",
            color = Color.Blue,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(250.dp)
        )
    }
}