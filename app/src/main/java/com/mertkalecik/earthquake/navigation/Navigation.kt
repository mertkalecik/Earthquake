package com.mertkalecik.earthquake.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mertkalecik.earthquake.ui.detail.DetailScreen
import com.mertkalecik.earthquake.ui.detail.DetailViewModel
import com.mertkalecik.earthquake.ui.home.HomeScreen
import com.mertkalecik.earthquake.ui.home.HomeViewModel
import com.mertkalecik.earthquake.ui.main.MainScreen
import com.mertkalecik.earthquake.ui.map.MapScreen
import com.mertkalecik.earthquake.ui.other.OtherScreen
import com.mertkalecik.earthquake.ui.splash.SplashScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel(),
    detailViewModel: DetailViewModel = hiltViewModel()
) = NavHost(
    navController = navController,
    startDestination = Screen.Home.route
) {
    composable(route = Screen.MainScreen.route) {
        MainScreen()
    }
    composable(route = Screen.Map.route) {
        MapScreen()
    }

    /**
     *  Bottom Navigation
     */
    composable(route = Screen.Home.route) {
        HomeScreen(navHostController = navController, viewModel = homeViewModel)
    }
    composable(route = Screen.Detail.route) {
        DetailScreen(navHostController = navController, viewModel = detailViewModel)
    }
    composable(route = Screen.Other.route) {
        OtherScreen()
    }
}
