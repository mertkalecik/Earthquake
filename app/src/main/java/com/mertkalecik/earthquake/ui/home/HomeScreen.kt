package com.mertkalecik.earthquake.ui.home

import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.mertkalecik.earthquake.base.EqToolbar

@Composable
fun HomeScreen() {
    val url = "https://github.com/mertkalecik"
    Home(url = url)
}

@Composable
fun Home(url: String) {
   EqToolbar(
        title = "Home",
        backIconClick = {
           Log.d("Mert","Back Button Clicked")
        }
    )
    LoadWebUrl(url = url)
}

@Composable
fun LoadWebUrl(url: String) {
    AndroidView(factory = {
        WebView(it).apply {
            webViewClient = WebViewClient()

            loadUrl(url)
        }
    },
        modifier = Modifier.padding(top = 56.dp)
    )
}

