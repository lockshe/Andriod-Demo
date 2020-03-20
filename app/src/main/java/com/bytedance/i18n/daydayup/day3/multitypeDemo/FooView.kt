package com.bytedance.i18n.daydayup.day3.multitypeDemo

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.bytedance.i18n.daydayup.R
import java.util.jar.Attributes

class FooView : LinearLayout{

    private lateinit var imageView1:ImageView

    constructor(context: Context) : super(context) {
        View.inflate(context, R.layout.multi_item_view, this)
        imageView1 = findViewById(R.id.multi_item_img)
    }

    fun bindData(id: Int) {
        imageView1.setImageResource(id)
    }
}