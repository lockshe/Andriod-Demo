package com.bytedance.i18n.daydayup.day5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.bytedance.i18n.daydayup.R
import java.util.*

class ViewPagerActivity : AppCompatActivity() {
    var viewPager: ViewPager? = null
    var fragments: MutableList<Fragment>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frag_pager)
        viewPager = findViewById(R.id.frag_view_page)
        initFragment()
        val adapter = FragAdapter(supportFragmentManager, fragments)
        viewPager!!.setAdapter(adapter)
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
    }
}