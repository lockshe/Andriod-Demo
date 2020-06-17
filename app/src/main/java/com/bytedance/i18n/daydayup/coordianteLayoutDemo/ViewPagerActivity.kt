package com.bytedance.i18n.daydayup.coordianteLayoutDemo

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.bytedance.i18n.daydayup.R
import kotlinx.android.synthetic.main.view_pager_activity.*

class ViewPagerActivity :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_pager_activity)

        view_pager.adapter = VpAdapter(supportFragmentManager)
        tab_layout.setupWithViewPager(view_pager)
    }

}

class VpAdapter(val fm: FragmentManager):FragmentPagerAdapter(fm){

    override fun getItem(position: Int): Fragment {
        return ViewPagerFragment()
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return "${position} + page"
    }

}

class MyViewPager @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : ViewPager(context, attrs){

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return super.onInterceptTouchEvent(ev)
    }


    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return super.onTouchEvent(ev)
    }


    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return super.dispatchTouchEvent(ev)
    }

}


class MyRecView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : RecyclerView(context, attrs){

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {

        if (ev == null){
            return super.onInterceptTouchEvent(ev)
        }

        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {

            }
            MotionEvent.ACTION_MOVE -> {

            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
            }
        }
        Log.d("yzjjj", "recyclerview intercept")
        return super.onInterceptTouchEvent(ev)
    }


    override fun onTouchEvent(ev: MotionEvent?): Boolean {

        Log.d("yzjjj", "recyclerview ontouch")
        return super.onTouchEvent(ev)
    }


    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {

        return super.dispatchTouchEvent(ev)
    }

}