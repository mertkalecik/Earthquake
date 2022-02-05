package com.mertkalecik.earthquake.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mertkalecik.earthquake.base.EqToolbar
import com.mertkalecik.earthquake.data.detail.DetailState

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    val state = viewModel.getUIState()
    Detail(navHostController = navHostController, state = state.value.uiState)
}

@Composable
fun Detail(
    navHostController: NavHostController,
    state: DetailState
) {

    Column {
        EqToolbar(
            title = "Detail",
            backIconClick = {
                navHostController.popBackStack()
            }
        )
        state.earthquakeModel?.let {
            Text(text = it.place)
        }
    }
}