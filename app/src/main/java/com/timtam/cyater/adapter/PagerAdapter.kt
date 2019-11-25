package com.timtam.cyater.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.timtam.cyater.fragment.ConverterFragment
import com.timtam.cyater.fragment.HistoryFragment

class PagerAdapter (fm: FragmentManager): FragmentPagerAdapter(fm) {

    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> ConverterFragment.newInstance()
            else -> HistoryFragment.newInstance()
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when(position) {
            0 -> {
                "Convert".apply {

                }
            }
            else -> {
                "History"
            }
        }
    }
}