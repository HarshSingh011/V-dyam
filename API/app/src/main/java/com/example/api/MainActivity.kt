package com.example.api

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var imageContainer: LinearLayout
    private val url = "https://api.thecatapi.com/v1/images/search?limit=10"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()
        fetchCatImages()
    }

    private fun initializeViews() {
        imageContainer = findViewById(R.id.imageContainer)
    }

    private fun fetchCatImages() {
        val requestQueue = Volley.newRequestQueue(this)
        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET,
            url,
            null,
            { response: JSONArray ->
                handleResponse(response)
            },
            { error ->
                handleError(error)
            }
        )

        requestQueue.add(jsonArrayRequest)
    }

    private fun handleResponse(response: JSONArray) {
        try {
            for (i in 0 until response.length()) {
                val catObject: JSONObject = response.getJSONObject(i)

                val imageUrl = catObject.getString("url")

                val imageView = ImageView(this)
                imageView.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )

                imageContainer.addView(imageView)

                Glide.with(this)
                    .load(imageUrl)
                    .into(imageView)
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Error parsing data: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    private fun handleError(error: VolleyError) {
        Toast.makeText(this, "Error found", Toast.LENGTH_LONG).show()
    }
}
