package com.bytedance.i18n.daydayup.day5

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.lang.IllegalArgumentException

class FragAdapter(
    fm: FragmentManager,
    private val fragments: List<Fragment>?
) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        if (fragments != null) {
            return fragments.get(position)
        }
        throw IllegalArgumentException() as Throwable
    }

    override fun getCount(): Int {
        if (fragments != null) {
            return fragments.size
        }
        throw IllegalArgumentException()
    }

}