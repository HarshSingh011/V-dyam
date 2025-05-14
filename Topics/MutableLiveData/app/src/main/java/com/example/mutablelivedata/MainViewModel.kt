package com.example.mutablelivedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val factsLiveDataObject = MutableLiveData<String>()

    init {
        factsLiveDataObject.value = "We are to much consern about our future"
    }

    val factsLiveData: LiveData<String>
        get() = factsLiveDataObject

    fun updateFacts() {
        factsLiveDataObject.value = "Understand yourself and keep your mind open and healthy for growth"
    }
}
