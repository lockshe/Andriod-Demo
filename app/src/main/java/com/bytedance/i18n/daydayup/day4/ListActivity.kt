package com.bytedance.i18n.daydayup.day4

import androidx.fragment.app.Fragment

class ListActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment? {
        return ListFragment()
    }
}