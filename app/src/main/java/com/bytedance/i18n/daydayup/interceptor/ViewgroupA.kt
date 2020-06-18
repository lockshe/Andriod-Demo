package com.bytedance.i18n.daydayup.interceptor

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView

class ViewGroupA @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : FrameLayout(context, attrs) {


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN -> Log.d("yzjjj", "A=======onTouch=====Down")
            MotionEvent.ACTION_MOVE -> Log.d("yzjjj", "A=======onTouch=====Move")
            MotionEvent.ACTION_UP -> Log.d("yzjjj", "A=========onTouch=====UP")
        }
        return super.onTouchEvent(event)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        when(ev?.action){
            MotionEvent.ACTION_DOWN -> Log.d("yzjjj", "A=======onIntercept=====Down")
            MotionEvent.ACTION_MOVE -> Log.d("yzjjj", "A=======onIntercept=====Move")
            MotionEvent.ACTION_UP -> Log.d("yzjjj", "A=========onIntercept=====UP")
        }
        return super.onInterceptTouchEvent(ev)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        when(ev?.action){
            MotionEvent.ACTION_DOWN -> Log.d("yzjjj", "A=======dispatchEvent=====Down")
            MotionEvent.ACTION_MOVE -> Log.d("yzjjj", "A=======dispatchEvent=====Move")
            MotionEvent.ACTION_UP -> Log.d("yzjjj", "A=========dispatchEvent=====UP")
        }
        return super.dispatchTouchEvent(ev)
    }

}

class ViewGroupB @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : FrameLayout(context, attrs) {


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN -> Log.d("yzjjj", "B=======onTouch=====Down")
            MotionEvent.ACTION_MOVE -> Log.d("yzjjj", "B=======onTouch=====Move")
            MotionEvent.ACTION_UP -> Log.d("yzjjj", "B=========onTouch=====UP")
        }

        return super.onTouchEvent(event)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        when(ev?.action){
            MotionEvent.ACTION_DOWN -> Log.d("yzjjj", "B=======onIntercept=====Down")
            MotionEvent.ACTION_MOVE -> Log.d("yzjjj", "B=======onIntercept=====Move")
            MotionEvent.ACTION_UP -> Log.d("yzjjj", "B=========onIntercept=====UP")
        }
        return super.onInterceptTouchEvent(ev)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        when(ev?.action){
            MotionEvent.ACTION_DOWN -> Log.d("yzjjj", "B=======dispatchEvent=====Down")
            MotionEvent.ACTION_MOVE -> Log.d("yzjjj", "B=======dispatchEvent=====Move")
            MotionEvent.ACTION_UP -> Log.d("yzjjj", "B=========dispatchEvent=====UP")
        }
        return super.dispatchTouchEvent(ev)
    }

}

class MyView @JvmOverloads constructor(context: Context, attrs: AttributeSet?= null, defStyleAttr: Int = 0): View(context, attrs, defStyleAttr){

    init {
        setOnTouchListener ( object : OnTouchListener{

            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                when(event?.action){
                    MotionEvent.ACTION_DOWN -> Log.d("yzjjj", "MyView=======Touch=====Down")
                    MotionEvent.ACTION_MOVE -> Log.d("yzjjj", "MyView=======Touch=====Move")
                    MotionEvent.ACTION_UP -> Log.d("yzjjj", "MyView=========Touch=====UP")
                }

                return false
            }

        })
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN -> Log.d("yzjjj", "MyView=======onTouch=====Down")
            MotionEvent.ACTION_MOVE -> Log.d("yzjjj", "MyView=======onTouch=====Move")
            MotionEvent.ACTION_UP -> Log.d("yzjjj", "MyView=========onTouch=====UP")
        }
        return true
    }


    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        when(ev?.action){
            MotionEvent.ACTION_DOWN -> Log.d("yzjjj", "MyView=======dispatchEvent=====Down")
            MotionEvent.ACTION_MOVE -> Log.d("yzjjj", "MyView=======dispatchEvent=====Move")
            MotionEvent.ACTION_UP -> Log.d("yzjjj", "MyView=========dispatchEvent=====UP")
        }
        return super.dispatchTouchEvent(ev)
    }



}


