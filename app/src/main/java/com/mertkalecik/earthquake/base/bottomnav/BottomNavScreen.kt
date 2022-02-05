package com.mertkalecik.earthquake.base.bottomnav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Map
import androidx.compose.ui.graphics.vector.ImageVector
import com.mertkalecik.earthquake.navigation.Screen

sealed class BottomNavScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomNavScreen(
        route = Screen.Home.route,
        title = "Home",
        icon = Icons.Default.Home
    )

    object Map : BottomNavScreen(
        route = Screen.Map.route,
        title = "Map",
        icon = Icons.Default.Map
    )

    object Other : BottomNavScreen(
        route = Screen.Other.route,
        title = "Other",
        icon = Icons.Default.Book
    )
}
