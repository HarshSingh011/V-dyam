package com.example.viewpager2

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fragmentActivity2: MainActivity2) : FragmentStateAdapter(fragmentActivity2){
    override fun getItemCount(): Int {
        return 3;
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> { fragment1()}
            1 -> { fragment2()}
            2 -> { fragment3()}
            else -> {throw Resources.NotFoundException("Position Not found")}
        }
    }
}