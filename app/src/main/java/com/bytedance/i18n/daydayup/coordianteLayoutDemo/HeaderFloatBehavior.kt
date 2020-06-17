package com.bytedance.i18n.daydayup.coordianteLayoutDemo

import android.animation.ArgbEvaluator
import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.os.Handler
import android.util.AttributeSet
import android.view.View
import android.widget.Scroller
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.RecyclerView
import com.bytedance.i18n.daydayup.R
import java.lang.ref.WeakReference
import kotlin.math.abs


class HeaderFloatBehavior @JvmOverloads constructor(val context: Context, val attributeSet: AttributeSet? = null )
    : CoordinatorLayout.Behavior<View>(context, attributeSet) {

    private var argbEvaluator = ArgbEvaluator()
    private lateinit var dependentView: View

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        return when (dependency.id) {
            R.id.scrolling_header -> {
                dependentView = dependency
                true
            }
            else -> false
        }
    }

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        val resource:Resources = dependentView.resources
        val progress = 1f - abs(dependency.translationY / (dependency.height - resource.getDimension(R.dimen.collapsed_header_height)))

        // Translation
        val collapsedOffset = resource.getDimension(R.dimen.collapsed_float_offset_y)
        val initOffset = resource.getDimension(R.dimen.init_float_offset_y)
        val translationY = collapsedOffset + (initOffset - collapsedOffset) * progress
        child.translationY = translationY
        //Background
        child.setBackgroundColor(argbEvaluator.evaluate(progress, resource.getColor(R.color.colorCollapsedFloatBackground), resource.getColor(R.color.colorInitFloatBackground)) as Int)

        //Margins
        val collapsedMargin = resource.getDimension(R.dimen.collapsed_float_margin)
        val initMargin = resource.getDimension(R.dimen.init_float_margin)
        val margin = (collapsedMargin + (initMargin - collapsedMargin) * progress).toInt()
        val lp =  child.layoutParams as CoordinatorLayout.LayoutParams
        lp.setMargins(margin, 0, margin, 0)
        child.layoutParams = lp
        return true
    }

}