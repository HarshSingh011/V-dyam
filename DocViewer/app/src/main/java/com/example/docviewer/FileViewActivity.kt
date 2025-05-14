package com.example.docviewer

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import java.net.URLEncoder

class FileViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fileUri = intent.data

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FileViewer(fileUri)
                }
            }
        }
    }
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun FileViewer(fileUri: Uri?) {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                settings.allowFileAccess = true
                settings.domStorageEnabled = true
                settings.allowContentAccess = true
                webViewClient = object : WebViewClient() {
                    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                        return false
                    }
                }
            }
        },
        update = { webView ->
            fileUri?.let { uri ->
                val encodedUrl = URLEncoder.encode(uri.toString(), "UTF-8")
                val mimeType = when {
                    uri.toString().endsWith(".pdf", ignoreCase = true) -> "application/pdf"
                    uri.toString().endsWith(".doc", ignoreCase = true) -> "application/msword"
                    uri.toString().endsWith(".docx", ignoreCase = true) -> "application/vnd.openxmlformats-officedocument.wordprocessingml.document"
                    else -> "application/octet-stream"
                }
                val url = "https://docs.google.com/gview?embedded=true&url=$encodedUrl"
                webView.loadUrl(url)
            }
        },
        modifier = Modifier.fillMaxSize()
    )
}

