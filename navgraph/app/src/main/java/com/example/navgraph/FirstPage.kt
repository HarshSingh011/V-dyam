package com.example.navgraph

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navgraph.R

class FirstPage : Fragment(R.layout.fragment_first_page) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loginButton: Button = view.findViewById(R.id.log)
        loginButton.setOnClickListener {
            findNavController().navigate(R.id.action_firstPage_to_secondPage)
        }

        val registerButton: Button = view.findViewById(R.id.Reg)
        registerButton.setOnClickListener {
            findNavController().navigate(R.id.action_firstPage_to_thirdPage)
        }
    }
}

