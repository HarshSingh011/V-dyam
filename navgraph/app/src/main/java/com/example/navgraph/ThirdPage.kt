package com.example.navgraph

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class ThirdPage : Fragment(R.layout.fragment_third_page) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val logAccTextView: TextView = view.findViewById(R.id.logAcc)
        logAccTextView.setOnClickListener {
            findNavController().navigate(R.id.action_thirdPage_to_secondPage)
        }
    }
}
