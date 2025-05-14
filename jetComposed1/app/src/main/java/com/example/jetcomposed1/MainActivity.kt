package com.example.jetcomposed1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val composeLayout = findViewById<ComposeView>(R.id.compose_layout)
        composeLayout.setContent {
            ListViewItem(imgId = R.drawable.ic_launcher_foreground, name = "Harsh", occupation = "Developer")
        }
        println("hello world ")
        println("hello world ")
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF, widthDp = 300, heightDp = 300)
@Composable
private fun ListViewItem(
    imgId: Int = R.drawable.ic_launcher_foreground,
    name: String = "Default Name",
    occupation: String = "Default Occupation"
) {
    Row (Modifier.padding(8.dp)){
        Image(
            painter = painterResource(id = imgId),
            contentDescription = "Android Logo",
            Modifier.size(100.dp)
        )
        Column {
            Text(
                text = name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = occupation,
                fontSize = 16.sp,
                fontWeight = FontWeight.Thin
            )
        }
    }
}