package com.mertkalecik.earthquake.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mertkalecik.earthquake.data.Event
import com.mertkalecik.earthquake.ui.detail.DetailScreen
import com.mertkalecik.earthquake.ui.home.HomeScreen
import com.mertkalecik.earthquake.ui.splash.SplashScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    onEvent: (Event) -> Unit
) = NavHost(
    navController = navController,
    startDestination = Screen.Splash.route
) {
    composable(route = Screen.Splash.route) {
        SplashScreen(navHostController = navController)
    }
    composable(route = Screen.Home.route) {
        HomeScreen(onEvent = onEvent, navHostController = navController)
    }
    composable(route = Screen.Detail.route) {
        DetailScreen(navHostController = navController, onEvent = onEvent)
    }
}
