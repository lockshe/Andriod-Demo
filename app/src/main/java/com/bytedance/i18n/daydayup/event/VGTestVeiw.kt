package com.bytedance.i18n.daydayup.event

import android.content.Context
import android.view.MotionEvent
import android.widget.LinearLayout
import com.bytedance.i18n.daydayup.R

class VGTestView(context: Context?): LinearLayout(context) {

    init {
        inflate(context, R.layout.event_activity, this)
    }


    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return super.onInterceptTouchEvent(ev)
    }


}