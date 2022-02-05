package com.mertkalecik.earthquake.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mertkalecik.earthquake.base.EqToolbar
import com.mertkalecik.earthquake.data.detail.DetailState
import com.mertkalecik.earthquake.ui.map.MapView

@Composable
fun DetailScreen(
    earthquakeId: Long,
    viewModel: DetailViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    val state = viewModel.getUIState()
    viewModel.init(earthquakeId)
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
            MapView(list = listOf(it))
        }
    }
}