package com.bytedance.i18n.daydayup.dayn

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

class BitmapView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0):
    View(context, attrs, defStyleAttr) {


    var mWidth = 0f

    var mHeight = 0f

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val height = getSize(0 , widthMeasureSpec)
        val width = getSize(0, heightMeasureSpec)
        setMeasuredDimension(width, height)
    }


    fun getSize(minSize:Int, spec:Int):Int {
        val specMode = MeasureSpec.getMode(spec)
        val specSize = MeasureSpec.getMode(spec)
        return when(specMode){
            MeasureSpec.AT_MOST -> if (minSize < specSize) minSize else specSize
            MeasureSpec.EXACTLY  -> specSize
            else -> minSize
        }
    }


}