package com.example.roomdb

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.roomdb.ui.theme.RoomGuideAndroidTheme

class MainActivity : AppCompatActivity() {

    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            ContactDatabase::class.java,
            "contact-db"
        ).build()
    }

    private val viewModel by viewModels<ContactViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return ContactViewModel(db.dao()) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()
        val composeLayout = findViewById<ComposeView>(R.id.compose_layout)
        composeLayout.setContent {
            RoomGuideAndroidTheme {
                val state by viewModel.state.collectAsState()
                ContactScreen(state = state, onEvent = viewModel::onEvent)
            }
        }
    }
}