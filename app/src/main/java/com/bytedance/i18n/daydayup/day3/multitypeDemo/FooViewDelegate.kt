package com.bytedance.i18n.daydayup.day3.multitypeDemo

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.drakeet.multitype.ItemViewDelegate
import kotlinx.android.synthetic.main.iv_menu.view.*

class FooViewDelegate: ItemViewDelegate<Foo, FooViewDelegate.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, item: Foo) {
        holder.fooView.bindData(item.value)
    }

    override fun onCreateViewHolder(context: Context, parent: ViewGroup): ViewHolder {

        return ViewHolder(FooView(context))
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val fooView : FooView = itemView as FooView
    }

}