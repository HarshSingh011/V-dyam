package com.example.jetpackcomposed


import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
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
//            Greeting1(name = "Harsh")
//            TextInput()
//            LayoutComposable()
            ListViewItem(imgId = R.drawable.ic_launcher_foreground, name = "Harsh", occupation = "Developer")
        }
    }
}


//@Composable
//private fun Greeting1(name: String = "Preview") {
//    Text(
//        text = "Hello $name!",
//        fontFamily = FontFamily.SansSerif,
//        fontStyle = FontStyle.Italic,
//        fontWeight = FontWeight.ExtraBold,
//        color = Color.Black,
//        fontSize = 36.sp
//    )
//
//    Image(
//        painter = painterResource(id = R.drawable.ic_launcher_foreground),
//        contentDescription = "Android Logo",
//        colorFilter = ColorFilter.tint(Color.Black),
//        contentScale = ContentScale.Crop
//    )
//
//    Button(onClick = { }, colors = ButtonDefaults.buttonColors(
//        contentColor = Color.Black,
//        backgroundColor = Color.White
//    )) {
//        Text(text = "Hello")
//        Image(
//            painter = painterResource(id = R.drawable.ic_launcher_foreground),
//            contentDescription = "Android Logo",
//            colorFilter = ColorFilter.tint(Color.Black),
//        )
//    }
//
//    TextField(
//        value = "name",
//        onValueChange = {},
//        label = {Text(text = "enter your name")},
//        placeholder = {Text(text = "123")},
//        )
//
//}

//@Composable
//private fun TextInput(){
//    val state = remember{mutableStateOf("")}
//    TextField(
//        value = state.value,
//        onValueChange = {
//            state.value = it
//        },
//        label = { Text(text = "Enter Message") },
//    )
//}
//
//@Composable
//private fun LayoutComposable(){
////    Column(
////        verticalArrangement = Arrangement.SpaceEvenly,
////        horizontalAlignment = Alignment.CenterHorizontally
////    ){
////        Text(text="A",fontSize = 24.sp)
////        Text(text="B",fontSize = 24.sp)
////    }
//
////    Row(
////        horizontalArrangement = Arrangement.SpaceEvenly,
////        verticalAlignment = Alignment.CenterVertically
////    ){
////        Text(text="A",fontSize = 24.sp)
////        Text(text="B",fontSize = 24.sp)
////    }
//
////    Box(contentAlignment = Alignment.Center){
////        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "Android background")
////        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "Android Logo")
////    }
//}

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
