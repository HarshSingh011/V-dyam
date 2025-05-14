package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class SecondPage : Fragment(R.layout.fragment_second_page) {
    class secondPage : Fragment(R.layout.fragment_second_page) {
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            val createAccTextView: TextView = view.findViewById(R.id.createAcc)
            createAccTextView.setOnClickListener {
                val thirdPageFragment = ThirdPage()
                parentFragmentManager.beginTransaction()
                    .replace(R.id.main, thirdPageFragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }