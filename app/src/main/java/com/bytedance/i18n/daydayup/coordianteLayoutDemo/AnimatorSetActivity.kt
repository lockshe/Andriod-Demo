package com.bytedance.i18n.daydayup.coordianteLayoutDemo

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.ScaleAnimation
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import com.bytedance.i18n.daydayup.R
import kotlinx.android.synthetic.main.activity_animatorset.*

class AnimatorSetActivity: AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animatorset)

        val o1 = ObjectAnimator.ofArgb(image1, "BackgroundColor", resources.getColor(R.color.white),
            resources.getColor(R.color.blue2) , resources.getColor(R.color.blue1))

        val o2 = ObjectAnimator.ofFloat(image1, "TranslationY", 0f, 300f, 0f)
        val o3 = ObjectAnimator.ofFloat(image2, "TranslationY", 0f, 400f, 0f)
        val o4 = ObjectAnimator.ofFloat(image3, "TranslationY", 0f, 500f, 0f)
        val o5 = ObjectAnimator.ofFloat(image4, "TranslationY", 0f, 600f, 0f)


        button1.setOnClickListener{
            //顺序播放
            val animatorSet = AnimatorSet()
            animatorSet.playSequentially(o1, o2, o3, o4, o5)
            animatorSet.duration = 2000L
            animatorSet.start()
        }

        button2.setOnClickListener{
            //并行播放
            val animatorSet = AnimatorSet()

            animatorSet.playTogether(o1, o2, o3, o4, o5)
            animatorSet.duration = 2000L
            animatorSet.startDelay = 1000L
            animatorSet.start()
        }
    }

}