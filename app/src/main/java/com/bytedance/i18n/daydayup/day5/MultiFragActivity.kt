package com.bytedance.i18n.daydayup.day5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bytedance.i18n.daydayup.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class MultiFragActivity : AppCompatActivity() {
    private var fragments: MutableList<Fragment>? = null
    private var bottomNavigationView: BottomNavigationView? = null
    private var lastFragmentId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.const_layout)
        initFragment()
    }

    private fun initFragment() {
        val fm = supportFragmentManager
        fragments = ArrayList()
        val homeFrag: Fragment = HomeFragment()
        val searchFrg: Fragment = SearchFragment()
        val mineFrag: Fragment = MineFragment()
        fragments!!.add(homeFrag)
        fragments!!.add(searchFrg)
        fragments!!.add(mineFrag)
        fm.beginTransaction()
            .replace(R.id.message, homeFrag)
            .show(homeFrag)
            .commit()
        // init the bottom navigation
        bottomNavigationView = findViewById(R.id.navigation)
        bottomNavigationView!!.setOnNavigationItemSelectedListener(changeFragment)
    }

    private val changeFragment =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    if (lastFragmentId != 0) {
                        changeFragment(0)
                    }
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_search -> {
                    if (lastFragmentId != 1) {
                        changeFragment(1)
                    }
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_mine -> {
                    if (lastFragmentId != 2) {
                        changeFragment(2)
                    }
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun changeFragment(index: Int) {
        val transaction =
            supportFragmentManager.beginTransaction()
        //hide the fragment
        transaction.hide(fragments!![lastFragmentId])
        if (fragments!![index].isAdded == false) {
            transaction.add(R.id.message, fragments!![index])
        }
        transaction.show(fragments!![index]).commitAllowingStateLoss()
        lastFragmentId = index
    }
}