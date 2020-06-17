package com.bytedance.i18n.daydayup.coordianteLayoutDemo

import android.content.Context
import android.os.Handler
import android.util.AttributeSet
import android.view.View
import android.widget.Scroller
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.bytedance.i18n.daydayup.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference
import kotlin.math.abs


class HeaderScrollingBehavior @JvmOverloads constructor(val context: Context,val attributeSet: AttributeSet? = null )
    : CoordinatorLayout.Behavior<RecyclerView>(context, attributeSet) {


    private var isExpanded = false
    private var isScrolling = false

    private lateinit var dependentView: View
    private var scroller: Scroller? = null

    init {
        scroller = Scroller(context)
    }

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: RecyclerView,
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


    override fun onLayoutChild(
        parent: CoordinatorLayout,
        child: RecyclerView,
        layoutDirection: Int
    ): Boolean {
//        val lp = child.layoutParams as CoordinatorLayout.LayoutParams
//        if (lp.height == CoordinatorLayout.LayoutParams.WRAP_CONTENT) {
//            child.layout(0, 0, parent.width, (parent.height - getDependentViewCollapsedHeight()).toInt());
//            return true;
//        }
        return super.onLayoutChild(parent, child, layoutDirection);

    }

    //image sacle
    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: RecyclerView,
        dependency: View
    ): Boolean {
        val resources = dependentView.resources
        val progress = 1f - abs(dependency.translationY / (dependency.height - resources.getDimension(R.dimen.collapsed_header_height)))

        child.translationY = (dependency.height  + dependency.translationY)

        val scale = 1 + 0.4f * (1f - progress)
        dependency.scaleX = scale
        dependency.scaleY = scale

        dependency.alpha = progress
        return true
    }

    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: RecyclerView,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int
    ): Boolean {
        return (axes and ViewCompat.SCROLL_AXIS_VERTICAL) != 0
    }

    override fun onNestedScrollAccepted(
        coordinatorLayout: CoordinatorLayout,
        child: RecyclerView,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int
    ) {
        scroller?.abortAnimation()
        isScrolling = false
        super.onNestedScrollAccepted(
            coordinatorLayout,
            child,
            directTargetChild,
            target,
            axes,
            type
        )
    }

    override fun onNestedPreScroll(
        coordinatorLayout: CoordinatorLayout,
        child: RecyclerView,
        target: View,
        dx: Int,
        dy: Int,
        consumed: IntArray,
        type: Int
    ) {
        if (dy < 0){
            return
        }

        val dependentView = dependentView
        val newTranslateY = dependentView?.translationY?.minus(consumed[1])

        newTranslateY?.let {
            if (it < 0f){
                dependentView.translationY = it
            }
        }
    }


    override fun onNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: RecyclerView,
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        type: Int
    ) {
        if (dyUnconsumed > 0){
            return
        }

        val newTranslateY = dependentView.translationY - dyConsumed
        val maxHeaderTranslate = 0

        if (newTranslateY < maxHeaderTranslate){
            dependentView.translationY = newTranslateY
        }

    }


    override fun onNestedPreFling(
        coordinatorLayout: CoordinatorLayout,
        child: RecyclerView,
        target: View,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        return onUserStopDragging(velocityY)
    }


    override fun onStopNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: RecyclerView,
        target: View,
        type: Int
    ) {
        if (!isScrolling){
            onUserStopDragging(800f)
        }
    }


    private fun onUserStopDragging(velocity: Float): Boolean{
        val dependentView = dependentView
        val translateY: Float = dependentView.translationY ?: 0f
        val minHeaderTranslate: Float = dependentView.height.let {
            -(it - getDependentViewCollapsedHeight())
        }?:0f
        var threshold = velocity

        if (translateY == 0f || translateY == minHeaderTranslate){
            return false
        }

        var targetState = false

        if (Math.abs(velocity) <= 800){
            targetState = abs(translateY) >= abs(translateY - minHeaderTranslate)
            threshold = 800f // limit the min
        }else{
            targetState = velocity > 0
        }

        var targetTranslationY = if (targetState) minHeaderTranslate else 0f
        scroller?.startScroll(0, translateY.toInt(), (targetTranslationY - translateY).toInt(), ((1000000 / abs(threshold)).toInt()))

        GlobalScope.launch {

            scroller?.let {scroller ->
                if (scroller.computeScrollOffset()){
                    dependentView?.translationY = scroller.currY.toFloat()
                } else{
                    isExpanded = dependentView?.translationY != 0f
                    isScrolling = false
                }
            }

        }

        isScrolling = true
        return true
    }

    private fun getDependentViewCollapsedHeight(): Float{
        return dependentView.resources?.getDimension(R.dimen.collapsed_header_height) ?: 0f
    }

}
