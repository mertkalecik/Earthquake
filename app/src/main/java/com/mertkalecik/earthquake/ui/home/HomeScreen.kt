package com.mertkalecik.earthquake.ui.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mertkalecik.earthquake.R
import com.mertkalecik.earthquake.base.EqSimpleToolbar
import com.mertkalecik.earthquake.base.Metrics.CARD_SIZE
import com.mertkalecik.earthquake.base.Metrics.CORNER_RADIUS
import com.mertkalecik.earthquake.base.Metrics.ELEVATION
import com.mertkalecik.earthquake.base.Metrics.PADDING_16
import com.mertkalecik.earthquake.base.Metrics.PADDING_8
import com.mertkalecik.earthquake.base.Metrics.TEXT_SIZE_MEDIUM
import com.mertkalecik.earthquake.data.home.EarthquakeModel
import com.mertkalecik.earthquake.data.home.EarthquakeUIModel
import com.mertkalecik.earthquake.data.home.HomeState
import com.mertkalecik.earthquake.navigation.Screen
import com.mertkalecik.earthquake.ui.theme.Purple700

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    navHostController: NavHostController
) {
    val state = viewModel.getUIState()
    Home(navHostController = navHostController, state = state.value.uiState)
}

@Composable
fun Home(
    navHostController: NavHostController,
    state: HomeState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 56.dp)
    ) {
        EqSimpleToolbar(
            title = "Earthquakes"
        )
        FillEarthquake(navHostController = navHostController, state)
    }
}

@Composable
fun FillEarthquake(
    navHostController: NavHostController,
    state: HomeState
) {
    state.homeState?.let {
        DrawEarthquakes(uiModel = it, navHostController = navHostController)
    }
}

@Composable
fun DrawEarthquakes(
    uiModel: EarthquakeUIModel,
    navHostController: NavHostController
) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = PADDING_16, vertical = PADDING_8),
        verticalArrangement = Arrangement.spacedBy(PADDING_8)
    ) {
        items(
            items = uiModel.dataList,
            itemContent = {
                EarthquakeItem(model = it, navHostController = navHostController)
            }
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EarthquakeItem(
    model: EarthquakeModel,
    navHostController: NavHostController
) {
    var expanded by remember { mutableStateOf(false) }
    val image = when (model.magnitude) {
        in 0.0..3.5 -> R.drawable.circle_green
        in 3.6..5.0 -> R.drawable.circle_yellow
        else -> R.drawable.circle_red
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(CORNER_RADIUS),
        elevation = ELEVATION,
        onClick = {
            navHostController.navigate(Screen.Detail.route + "/${model.id}")
        }
    ) {
        Column {
            Row {
                DrawCircularMag(model.magnitude, imageRes = image)
                Text(
                    text = model.place,
                    modifier = Modifier.padding(start = PADDING_16, top = PADDING_16)
                )
            }

            if (expanded) {
                Text(
                    text = "Date: ${model.date}",
                    modifier = Modifier.padding(start = PADDING_16, top = PADDING_16)
                )
                Text(
                    text = "Title: ${model.title}",
                    modifier = Modifier.padding(start = PADDING_16, top = PADDING_16)
                )
                Text(
                    text = "Latitude: ${model.latitude}",
                    modifier = Modifier.padding(start = PADDING_16, top = PADDING_16)
                )
                Text(
                    text = "Longitude: ${model.longitude}",
                    modifier = Modifier.padding(start = PADDING_16, top = PADDING_16)
                )
                IconButton(
                    modifier = Modifier.fillMaxSize(),
                    onClick = { expanded = false }
                ) {
                    Icon(imageVector = Icons.Default.ExpandLess, contentDescription = "Collapse")
                }
            } else {
                IconButton(
                    modifier = Modifier.fillMaxSize(),
                    onClick = { expanded = true }
                ) {
                    Icon(imageVector = Icons.Default.ExpandMore, contentDescription = "Expand")
                }
            }
        }
    }
}

@Composable
fun DrawCircularMag(mag: Double, @DrawableRes imageRes: Int) {
    Box(modifier = Modifier.size(CARD_SIZE)) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape),
            painter = painterResource(id = imageRes),
            contentDescription = mag.toString(),
            contentScale = ContentScale.Fit
        )
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = mag.toString(),
                style = TextStyle(color = Color.Black, fontSize = TEXT_SIZE_MEDIUM)
            )
        }
    }
}

@Preview
@Composable
fun DrawCircularMagPreview() {
    DrawCircularMag(mag = 5.6, imageRes = R.drawable.circle_red)
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

