package com.bytedance.i18n.daydayup.day3.multitypeDemo

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.bytedance.i18n.daydayup.R
import java.util.jar.Attributes

class FooView : LinearLayout {

    val imageView = findViewById<ImageView>(R.id.img1)

    constructor(context: Context):super(context){
        View.inflate(context, R.layout.item_second_view, this)
    }

    fun bindData(id: Int){
        imageView.setImageResource(id)
    }
}