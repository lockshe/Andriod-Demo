package com.bytedance.i18n.daydayup.snaphelper

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.bytedance.i18n.daydayup.R
import kotlinx.android.synthetic.main.snap_litem_ayout.view.*

class SnapView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0 ):
    RelativeLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.snap_litem_ayout, this)

    }

    fun bindData(data: String){
        iv_title.text = data
    }
}