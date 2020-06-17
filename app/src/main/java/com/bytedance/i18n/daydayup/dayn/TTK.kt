package com.bytedance.i18n.daydayup.dayn


import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kotlin.math.min


class PKView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    //绘制红色区域
    private val redPath = Path().apply {
        addArc(RectF(10F, 10F, 110F, 110F), 90F, 180F)
        lineTo(428F, 10F)
        lineTo(392F, 110F)
        lineTo(60F, 110F)
        close()
    }

    //绘制蓝色区域
    private val bluePath = Path().apply {
        arcTo(RectF(512F, 10F, 612F, 110F), 270F, 180F)
        lineTo(402F, 110F)
        lineTo(438F, 10F)
        lineTo(562F, 10F)
        close()
    }

    private val whitePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.WHITE
        style = Paint.Style.FILL
        strokeJoin = Paint.Join.ROUND
        strokeWidth = 10F
    }

    private val redPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
        style = Paint.Style.FILL
        strokeJoin = Paint.Join.ROUND
        strokeWidth = 10F
        pathEffect = CornerPathEffect(10F)
        shader = LinearGradient(
            0F, 0F, 500F, 500F, Color.parseColor("#ff5a33"),
            Color.parseColor("#ff9b52"), Shader.TileMode.CLAMP
        )
    }

    private val bluePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLUE
        style = Paint.Style.FILL
        strokeJoin = Paint.Join.ROUND
        strokeWidth = 10F
        pathEffect = CornerPathEffect(10F)
        shader = LinearGradient(
            0F, 0F, 500F, 500F, Color.parseColor("#77c1ff"),
            Color.parseColor("#2697ff"), Shader.TileMode.CLAMP
        )
    }

    private var mSize = 0

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = getMeasureSize(widthMeasureSpec)
        val height = getMeasureSize(heightMeasureSpec)
        mSize = min(width, height)
        setMeasuredDimension(mSize, mSize)
    }

    private val DEFAULT_SIZE = 200

    private fun getMeasureSize(measureSpec: Int): Int {
        val mode = MeasureSpec.getMode(measureSpec)
        val size = MeasureSpec.getSize(measureSpec)
        return if (mode == MeasureSpec.EXACTLY) size else DEFAULT_SIZE
    }

    fun startShow() {
        ValueAnimator.ofFloat(0f, 1F).apply {
            duration = 1000
            addUpdateListener { updatedAnimation ->
                distance = updatedAnimation.animatedValue as Float
                invalidate()
            }
            start()
        }
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawBg(canvas)
        drawPreBg(canvas)
    }


    var distance = 0.0F

    private fun drawBg(canvas: Canvas) {
        canvas.drawPath(redPath, redPaint)
        canvas.drawPath(bluePath, bluePaint)
    }


    //绘制遮罩
    private fun drawPreBg(canvas: Canvas) {
        var whitePath = Path()
        if (distance > 0F) {
            whitePath = buildRect()
        } else {
            whitePath.addRect(RectF(10F, 10F, 612F, 110F), Path.Direction.CW)
        }


        canvas.drawPath(whitePath, whitePaint)
    }


    var top = 10F
    var bottom = 110F
    var left = 10F
    var right = 612F

    fun buildRect(): Path {
        left = distance * 392F
        right = 612F - distance * (612F - 392)
        val whitePath = Path()
        whitePath.moveTo(left, bottom)
        whitePath.lineTo(right, bottom)
        whitePath.lineTo(right + 36F, top)
        whitePath.lineTo(left + 36F, top)
        whitePath.close()

        return whitePath
    }
}

