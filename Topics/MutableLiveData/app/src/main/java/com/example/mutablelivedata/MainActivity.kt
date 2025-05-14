package com.example.mutablelivedata

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    private val factsTextView: TextView
        get() = findViewById(R.id.factsTextView)

    private val btnUpdate: Button
        get() = findViewById(R.id.btnUpdate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.factsLiveData.observe(this) {
            factsTextView.text = it
        }

        btnUpdate.setOnClickListener{
            mainViewModel.updateFacts()
        }
    }
}
