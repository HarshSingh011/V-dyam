package com.example.lifecyclerobserver

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var txtCounter : TextView
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(Observer())
        Log.d("MainActivity", "onCreate")
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(10)).get(MainViewModel::class.java)  // we are passing the lifecyele of the activity
        txtCounter = findViewById(R.id.counter)
        findViewById<View>(R.id.increment).setOnClickListener {
            mainViewModel.increment()
            setText()
        }
        setText()
    }

    fun setText(){
        txtCounter.text = mainViewModel.count.toString()
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }
}