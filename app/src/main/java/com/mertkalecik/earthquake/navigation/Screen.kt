package com.mertkalecik.earthquake.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Home : Screen("home_screen")
    object Detail : Screen("detail_screen")
    object Map : Screen("map_screen")
    object Other : Screen("other_screen")
    object MainScreen : Screen("main_screen")
}