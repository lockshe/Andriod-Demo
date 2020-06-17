package com.bytedance.i18n.daydayup.dayn

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class  RecViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

}

class RecAdapter(val dataList: ArrayList<Int>) : RecyclerView.Adapter<RecViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecViewHolder {
        Log.d("yzjjjj","create-------")
        return RecViewHolder(TextView(parent.context))
    }


    override fun onBindViewHolder(holder: RecViewHolder, position: Int) {
        Log.d("yzjjjj","bind-------")
        (holder.itemView as TextView).apply {
            text = "position at ${position}"
            layoutParams = ViewGroup.LayoutParams(400, 400)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onViewAttachedToWindow(holder: RecViewHolder) {
        super.onViewAttachedToWindow(holder)
        Log.d("yzjjjj","enter into-------")
    }

    override fun onViewDetachedFromWindow(holder: RecViewHolder) {
        super.onViewDetachedFromWindow(holder)
        Log.d("yzjjj,","leave -------")
    }

}