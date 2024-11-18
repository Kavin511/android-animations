package com.sp45.android_animations.util

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.sp45.android_animations.R

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewScreen() {
    val url = stringResource(R.string.https_www_crakcode_in)
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                webViewClient = WebViewClient()
                loadUrl(url)
            }
        }
    )
}

@Composable
fun WebAppText(onClick: () -> Unit) {
    val annotatedString = buildAnnotatedString {
        pushStringAnnotation(tag = "URL", annotation = "https://www.crakcode.in/")
        withStyle(style = TextStyle(color = Color.Green, textDecoration = TextDecoration.Underline).toSpanStyle()) {
            append(stringResource(R.string.visit_crakcode_website_for))
        }
        pop()
    }

    Text(
        text = annotatedString,
        style = TextStyle(fontSize = 16.sp),
        modifier = Modifier.clickable {
            onClick()
        }
    )
}