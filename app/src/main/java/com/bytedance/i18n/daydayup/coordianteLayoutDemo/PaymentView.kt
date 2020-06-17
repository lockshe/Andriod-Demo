package com.bytedance.i18n.daydayup.coordianteLayoutDemo

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View

class PaymentView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    View(context, attrs, defStyleAttr) {

    val dstPath = Path()

    val circlePath = Path().apply {
        addCircle(100F, 100F, 50F, Path.Direction.CW)

        moveTo(75F, 100F)
        lineTo(100F, 125F)
        lineTo(125f, 100f - 50f/3f)
    }

    val paint = Paint().apply {
        flags = Paint.ANTI_ALIAS_FLAG
        style = Paint.Style.STROKE
        strokeWidth = 4F
        color = Color.BLACK
    }

    //force closed the path when you set true
    val pathMeasure = PathMeasure(circlePath, false)

    var measureValue = 0f


    var next = false
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawColor(Color.WHITE)

        if (measureValue < 1){
            val stop = pathMeasure.length * measureValue
            pathMeasure.getSegment(0f, stop, dstPath,true)
        }else{
            if (!next){
                next = true
                pathMeasure.getSegment(0f, pathMeasure.length, dstPath, true)
                pathMeasure.nextContour()
            }

            val stop = pathMeasure.length * (measureValue - 1)
            pathMeasure.getSegment(0f, stop, dstPath, true)
        }

        canvas?.drawPath(dstPath, paint)
    }

    fun startAnimation(){
        ValueAnimator.ofFloat(0f, 2f).apply {
            // 0f to 2f
            addUpdateListener {
                duration = 4000L
                measureValue = it.animatedValue as Float
                invalidate()
            }
            start()
        }
    }
}