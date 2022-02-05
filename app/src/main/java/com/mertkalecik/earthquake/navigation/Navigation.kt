package com.mertkalecik.earthquake.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mertkalecik.earthquake.ui.detail.DetailScreen
import com.mertkalecik.earthquake.ui.detail.DetailViewModel
import com.mertkalecik.earthquake.ui.home.HomeScreen
import com.mertkalecik.earthquake.ui.home.HomeViewModel
import com.mertkalecik.earthquake.ui.main.MainScreen
import com.mertkalecik.earthquake.ui.map.MapScreen
import com.mertkalecik.earthquake.ui.other.OtherScreen

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
    composable(
        route = Screen.Detail.route + "/{earthquakeId}",
        arguments = listOf(
            navArgument("earthquakeId") { type = NavType.LongType }
        )
    ) {
        it.arguments?.getLong("earthquakeId")?.let { id ->
            DetailScreen(
                earthquakeId = id,
                navHostController = navController,
                viewModel = detailViewModel
            )
        }
    }

    /**
     *  Bottom Navigation
     */
    composable(route = Screen.Home.route) {
        HomeScreen(navHostController = navController, viewModel = homeViewModel)
    }
    composable(route = Screen.Map.route) {
        MapScreen()
    }
    composable(route = Screen.Other.route) {
        OtherScreen()
    }
}
