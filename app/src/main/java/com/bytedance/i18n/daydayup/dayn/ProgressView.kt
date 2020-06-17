package com.bytedance.i18n.daydayup.dayn

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.bytedance.i18n.daydayup.R
import kotlin.math.log

class ProgressView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :View(context, attrs, defStyleAttr){

    val redPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        strokeJoin = Paint.Join.ROUND
        pathEffect = CornerPathEffect(10F)
        shader = LinearGradient(0F, 0F, mHeight, mWidth, Color.parseColor("#ff5a33"), Color.parseColor("#ff9b52"), Shader.TileMode.CLAMP)
    }

    val bluePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        strokeJoin = Paint.Join.ROUND
        pathEffect = CornerPathEffect(10F)
        shader = LinearGradient(0F, 0F, mHeight, mWidth, Color.parseColor("#77c1ff"), Color.parseColor("#2697ff"), Shader.TileMode.CLAMP)

    }

    val rectPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.parseColor("#000000")
    }

    private val totalCount: Float = 100f

    private var mHeight: Float = 0f

    private var mWidth: Float = 0f

    var mYesCount: Float? = 0f

    var mNoCount: Float? = 0f

    private val offset = 20f

    private val divide = 5f

    var scale = 1f

    val step = 0f

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val yesPath = Path()
        val round = mHeight / 2f
        val propotion = mYesCount?.div(totalCount) ?: 0f
        val clipPoint = mWidth * propotion
        val arcRec = RectF(0f, 0f, round * 2, round * 2)
        val leftXTop = clipPoint - divide
        val leftXBot = clipPoint - divide - offset

        yesPath.arcTo(arcRec, 90f, 180f)
        yesPath.lineTo(leftXTop, 0f)
        yesPath.lineTo(leftXBot, mHeight)
        yesPath.lineTo(round, mHeight)
        yesPath.close()
        canvas?.drawPath(yesPath, redPaint)
        

        val noPath = Path()
        val arcRec2 = RectF(mWidth - round * 2, 0f, mWidth, round * 2)
        val rightXTop = clipPoint + divide
        val rightXBot = clipPoint + divide - offset
        noPath.arcTo(arcRec2, 90f, -180f)
        noPath.lineTo(rightXTop, 0f)
        noPath.lineTo(rightXBot, mHeight)
        noPath.lineTo(mWidth - round, mHeight)
        noPath.close()
        canvas?.drawPath(noPath, bluePaint)

//        scaling a rectangle to implement the progress animation

        val rectF = RectF(0f, 0f, mWidth/3, mHeight/3)

        if (scale <= 3f){
            canvas?.drawRect(rectF, rectPaint)
            canvas?.scale(scale + step, 1f)
            invalidate()
        }

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthSpecMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSpecSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightSpecMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSpecSize = MeasureSpec.getSize(heightMeasureSpec)

        if (widthSpecMode == MeasureSpec.EXACTLY || widthSpecMode == MeasureSpec.AT_MOST) {
            mWidth = widthSpecSize.toFloat();
        } else {
            mWidth = 0f;
        }
        if (heightSpecMode == MeasureSpec.AT_MOST || heightSpecMode == MeasureSpec.UNSPECIFIED) {
            mHeight = 0f;
        } else {
            mHeight = heightSpecSize.toFloat();
        }
        setMeasuredDimension(mWidth.toInt(), mHeight.toInt());

    }


    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
    }

}