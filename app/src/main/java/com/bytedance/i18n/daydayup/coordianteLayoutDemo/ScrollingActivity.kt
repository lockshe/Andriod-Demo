package com.bytedance.i18n.daydayup.coordianteLayoutDemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.animation.ScaleAnimation
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bytedance.i18n.daydayup.R
import kotlinx.android.synthetic.main.activity_scrolling.*
import kotlinx.android.synthetic.main.test_linear.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class ScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_scrolling)
//        rec_view.adapter = RecAdapter()
//        rec_view.layoutManager = LinearLayoutManager(this)

        setContentView(R.layout.test_linear)
//        progress.mYesCount = 50f
//        progress.mNoCount = 50f
//
//        iv_animation.visibility = View.VISIBLE
//
//        val animation = ScaleAnimation(1f, 0f, 1f, 1f, 500f, 0f)
//        animation.duration = 2000L
//        iv_animation.startAnimation(animation)
//        plus_view.mYesCount = 20f
//        plus_view.mNoCount = 80f
//        plus_view.startShow()

        payment_view.startAnimation()
    }

}

