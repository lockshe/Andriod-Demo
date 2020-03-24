package com.bytedance.i18n.daydayup.day5

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FragAdapter(
    fm: FragmentManager,
    private val fragments: List<Fragment>?
) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return fragments!![position]
    }

    override fun getCount(): Int {
        return fragments!!.size
    }

}