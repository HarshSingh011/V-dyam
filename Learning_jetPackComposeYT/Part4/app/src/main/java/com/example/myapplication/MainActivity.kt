package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextContent()
        }
    }
}

private val fontFamily = FontFamily(
    Font(R.font.lexend_black, FontWeight.Thin),
    Font(R.font.lexend_bold, FontWeight.Bold),
    Font(R.font.lexend_extrabold, FontWeight.ExtraBold),
    Font(R.font.lexend_extralight, FontWeight.ExtraLight),
    Font(R.font.lexend_light, FontWeight.Light),
    Font(R.font.lexend_medium, FontWeight.Medium),
    Font(R.font.lexend_regular, FontWeight.Normal),
    Font(R.font.lexend_semibold, FontWeight.SemiBold),
    Font(R.font.lexend_thin, FontWeight.Thin)
)

@Composable
private fun TextContent() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF101010))){
        Text(
            text = "Hello, World!",
            color = Color.White,
            fontSize = 30.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline
        )
    }
}

