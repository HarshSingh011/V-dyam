package com.example.viewpager2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val images = listOf(
            R.drawable.ast,
            R.drawable.bug,
            R.drawable.far,
            R.drawable.corvet,
            R.drawable.ford,
            R.drawable.kon,
            R.drawable.lambo,
            R.drawable.maje,
            R.drawable.mal,
            R.drawable.pagani,
            R.drawable.por
        )

        val loginBtn = findViewById<Button>(R.id.next)
        loginBtn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val adapter = ViewPagerAdapter(images)
        viewPager.adapter = adapter
    }
}