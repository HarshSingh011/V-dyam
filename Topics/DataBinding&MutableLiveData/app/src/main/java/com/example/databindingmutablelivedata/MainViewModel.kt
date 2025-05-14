package com.example.databindingmutablelivedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){

    val quoteLiveData = MutableLiveData("What you seek is seeking you.")

    fun updateQuote(){
        quoteLiveData.value = "The wound is the place where the light enters you."
    }
}