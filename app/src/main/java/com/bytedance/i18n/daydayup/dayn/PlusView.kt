package com.bytedance.i18n.daydayup.dayn

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View

class PlusView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    View(context, attrs, defStyleAttr) {


    val redPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
//        strokeJoin = Paint.Join.ROUND
        pathEffect = CornerPathEffect(10F)
    }

    val bluePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
//        strokeJoin = Paint.Join.ROUND
        pathEffect = CornerPathEffect(10F)

    }

    val whitePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#ffffff")
    }

    private val totalCount: Float = 100f

    private var mHeight: Float = 0f

    private var mWidth: Float = 0f

    var mYesCount: Float? = 0f

    var mNoCount: Float? = 0f

    private val offset = 20f

    private val divide = 5f

    var round = 0f

    var clipPoint = 0f

    var yesPath = Path()

    var noPath = Path()

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        buildPath()
        canvas?.drawPath(yesPath, redPaint)
        canvas?.drawPath(noPath, bluePaint)
        canvas?.drawPath(buildWhitePath(), whitePaint)
    }


    fun buildWhitePath(): Path{
        // 左上角的点
        // distance 是百分比
        val leftBottomX = clipPoint * distance
        val rightTopX = mWidth - (mWidth - clipPoint) * distance
        //需要考虑极端情况
        Log.d("value", "right ${rightTopX }")
        Log.d("value", "left ${leftBottomX}")
        return Path().apply {
            if (leftBottomX < clipPoint - divide - offset && rightTopX > clipPoint){
                moveTo(leftBottomX, mHeight)
                lineTo(rightTopX - offset, mHeight)
                lineTo(rightTopX, 0f)
                lineTo(leftBottomX + offset , 0f)
                close()
            }else{
                clearAnimation()
            }
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

        round = mHeight / 2f

        val propotion = mYesCount?.div(totalCount) ?: 0f

        clipPoint = mWidth * propotion

        redPaint.shader = LinearGradient(0F, 0F, clipPoint, mHeight, Color.parseColor("#ff5a33"), Color.parseColor("#ff9b52"), Shader.TileMode.CLAMP)
        bluePaint.shader = LinearGradient(clipPoint, 0F, mWidth, mHeight, Color.parseColor("#77c1ff"), Color.parseColor("#2697ff"), Shader.TileMode.CLAMP)

        setMeasuredDimension(mWidth.toInt(), mHeight.toInt());
    }

    var distance = 0f

    fun buildPath(){

        yesPath.apply {

            val arcRec = RectF(0f, 0f, round * 2, round * 2)
            val rightXTop = clipPoint - divide
            val rightXBot = clipPoint - divide - offset

            arcTo(arcRec, 90f, 180f)
            lineTo(rightXTop, 0f)
            lineTo(rightXBot, mHeight)
//            lineTo(round, mHeight)
            close()
        }

        noPath.apply {
            val arcRec2 = RectF(mWidth - round * 2, 0f, mWidth, round * 2)
            val leftXTop = clipPoint + divide
            val leftXBot = clipPoint + divide - offset
            arcTo(arcRec2, 90f, -180f)
            lineTo(leftXTop, 0f)
            lineTo(leftXBot, mHeight)
//            lineTo(mWidth - round, mHeight)
            close()
        }

    }

    fun startShow(){
        ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 1000L
            addUpdateListener { updateAnimation ->
                if (distance >= 0f){
                    distance = updateAnimation.animatedValue as Float
                    invalidate()
                }
            }
            start()
        }
    }

}