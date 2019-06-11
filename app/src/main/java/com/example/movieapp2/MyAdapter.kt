package com.example.movieapp2

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyAdapter (private val myContext: Context, fm : FragmentManager, internal var totalTabs: Int):
    FragmentPagerAdapter(fm)
{
    override fun getCount(): Int {
        return totalTabs
    }

    override fun getItem(position: Int): Fragment?{
        when (position){
            0 -> {
                return PopularFragment()
            }
            1 -> {
                return TopRatedFragment()
            }
            else -> return null
        }
    }
}