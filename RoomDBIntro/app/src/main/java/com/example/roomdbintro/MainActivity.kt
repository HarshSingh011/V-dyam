package com.example.roomdbintro

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.room.Room
import com.example.roomdbintro.ContactDatabase

class MainActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        database = Room.databaseBuilder(
            applicationContext,
            ContactDatabase::class.java,
            "contact.db"
        ).build()

        GlobalScope.launch {
            database.contactDAO().insertContact(Contact(0, "John Doe", "1234567890"))
        }
    }

    fun getData(view: View){
        database.contactDAO().getContact().observe(this, Observer {
            Log.d("MainActivity", it.toString())
        })
    }

}