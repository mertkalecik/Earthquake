package com.mertkalecik.earthquake.ui.detail

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.mertkalecik.earthquake.base.EqToolbar
import com.mertkalecik.earthquake.data.Event

@Composable
fun DetailScreen(
    navHostController: NavHostController,
    onEvent: (Event) -> Unit
) {
    Detail(onEvent = onEvent, navHostController = navHostController)
}

@Composable
fun Detail(
    onEvent: (Event) -> Unit,
    navHostController: NavHostController
) {
    EqToolbar(
        title = "Detail",
        backIconClick = {
            navHostController.popBackStack()
        }
    )
}