package com.example.docviewer

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            openFile(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(
                        onOpenFile = { getContent.launch("application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document") },
                        onOpenRecentFile = { uri -> openFile(uri) }
                    )
                }
            }
        }
    }

    private fun openFile(uri: Uri) {
        val intent = Intent(this, FileViewActivity::class.java).apply {
            data = uri
        }
        startActivity(intent)
        saveRecentFile(uri)
    }

    private fun saveRecentFile(uri: Uri) {
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        val recentFiles = sharedPref.getStringSet("recent_files", mutableSetOf())?.toMutableSet() ?: mutableSetOf()
        recentFiles.add(uri.toString())
        if (recentFiles.size > 5) {
            recentFiles.remove(recentFiles.first())
        }
        with(sharedPref.edit()) {
            putStringSet("recent_files", recentFiles)
            apply()
        }
    }
}

@Composable
fun MainScreen(onOpenFile: () -> Unit, onOpenRecentFile: (Uri) -> Unit) {
    val context = LocalContext.current
    val recentFiles = remember { mutableStateListOf<Uri>() }

    LaunchedEffect(Unit) {
        val sharedPref = context.getSharedPreferences("com.example.docviewer.prefs", Context.MODE_PRIVATE)
        val savedRecentFiles = sharedPref.getStringSet("recent_files", setOf())
        recentFiles.clear()
        recentFiles.addAll(savedRecentFiles?.mapNotNull { Uri.parse(it) } ?: emptyList())
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = onOpenFile,
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Open PDF/DOC/DOCX")
        }

        if (recentFiles.isNotEmpty()) {
            Text(
                "Recent Files",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(16.dp)
            )
            LazyColumn {
                items(recentFiles) { uri ->
                    Text(
                        text = uri.lastPathSegment ?: "Unknown file",
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onOpenRecentFile(uri) }
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}

