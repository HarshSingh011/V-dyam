package com.example.jetpackpart2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackpart2.ui.theme.Jetpackpart2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting()
        }
    }
}

@Preview(showBackground = true,backgroundColor = 0xFFFFFFFF, widthDp = 300, heightDp = 300)
@Composable
private fun Greeting() {
    Column(
        modifier = Modifier
            .background(Color.Green)
            .fillMaxHeight(0.5f)
            .width(600.dp)
//            .padding(top = 50.dp)
            .border(5.dp, Color.White)
            .padding(5.dp)
            .border(5.dp, Color.Black)
            .padding(5.dp)
            .border(5.dp, Color.White)
            .padding(5.dp)
            .border(5.dp, Color.Black)
            .padding(5.dp)
    ){
        Text("Hello",modifier = Modifier
//            .offset(0.dp,20.dp)) // left bottom
            .clickable {

            })
        Spacer(modifier = Modifier.height(50.dp))
        Text("World")
    }
}
