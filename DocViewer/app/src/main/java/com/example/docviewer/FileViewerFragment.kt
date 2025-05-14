package com.example.docviewer

import android.net.Uri
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

@Composable
fun FileViewerFragment(uri: Uri, onError: () -> Unit) {
    val context = LocalContext.current
    val mimeType = remember(uri) {
        context.contentResolver.getType(uri) ?: when {
            uri.toString().endsWith(".pdf", ignoreCase = true) -> "application/pdf"
            uri.toString().endsWith(".txt", ignoreCase = true) -> "text/plain"
            else -> "*/*"
        }
    }

    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { ctx ->
            WebView(ctx).apply {
                settings.javaScriptEnabled = true
                webViewClient = object : WebViewClient() {
                    override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                        super.onReceivedError(view, request, error)
                        onError()
                    }
                }

                when {
                    mimeType.startsWith("application/pdf") -> {
                        loadUrl("https://docs.google.com/gview?embedded=true&url=${uri}")
                    }
                    mimeType.startsWith("text/") -> {
                        val content = if (uri.scheme == "http" || uri.scheme == "https") {
                            URL(uri.toString()).openStream().use { inputStream ->
                                BufferedReader(InputStreamReader(inputStream)).useLines { lines ->
                                    lines.joinToString("\n")
                                }
                            }
                        } else {
                            context.contentResolver.openInputStream(uri)?.use { inputStream ->
                                BufferedReader(InputStreamReader(inputStream)).useLines { lines ->
                                    lines.joinToString("\n")
                                }
                            }
                        } ?: "Unable to read file content"
                        loadDataWithBaseURL(null, "<pre>$content</pre>", "text/html", "UTF-8", null)
                    }
                    else -> {
                        loadUrl("https://docs.google.com/gview?embedded=true&url=${uri}")
                    }
                }
            }
        }
    )
}

