package com.example.lifecyclerobserver

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class Observer: DefaultLifecycleObserver {

    override fun onCreate(owner: LifecycleOwner) {
        Log.d("Observer", "onCreate")
    }

    override fun onStart(owner: LifecycleOwner) {
        Log.d("Observer", "onStart")
    }

    override fun onResume(owner: LifecycleOwner) {
        Log.d("Observer", "onResume")
    }

    override fun onPause(owner: LifecycleOwner) {
        Log.d("Observer", "onPause")
    }

    override fun onStop(owner: LifecycleOwner) {
        Log.d("Observer", "onStop")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        Log.d("Observer", "onDestroy")
    }
}