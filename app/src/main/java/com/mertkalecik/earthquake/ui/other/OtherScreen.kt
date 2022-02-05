package com.mertkalecik.earthquake.ui.other

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.mertkalecik.earthquake.base.EqSimpleToolbar

@Composable
fun OtherScreen() {
    val url = "https://github.com/mertkalecik"
    Other(url = url)
}

@Composable
fun Other(url: String) {
    Column {
        EqSimpleToolbar(title = "Contributor")
        LoadWebUrl(url = url)
    }
}

@Composable
fun LoadWebUrl(url: String) {
    AndroidView(
        factory = {
            WebView(it).apply {
                webViewClient = WebViewClient()

                loadUrl(url)
            }
        },
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 56.dp)
    )
}