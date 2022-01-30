package com.mertkalecik.earthquake.base

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mertkalecik.earthquake.ui.theme.Purple700

@Composable
fun EqToolbar(
    title: String,
    backIconClick: (() -> Unit)? = null
) {
    TopAppBar(
        title = { Text(text = title, color = Color.White) },
        navigationIcon = {
            IconButton(onClick = { backIconClick?.invoke() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back Button",
                    tint = Color.White
                )
            }
        },
        backgroundColor = Purple700,
        contentColor = Color.Gray,
        elevation = 2.dp
    )
}