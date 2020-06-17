package com.bytedance.i18n.daydayup.coordianteLayoutDemo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bytedance.i18n.daydayup.R
import com.bytedance.i18n.daydayup.dayn.RecViewHolder
import kotlinx.android.synthetic.main.item_simple.view.*

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

}

class RecAdapter: RecyclerView.Adapter<ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_simple, parent, false))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.text.text = "Fake Item ${position + 1}"
        holder.itemView.text2.text = "See you Space Cowboy, Someday Somewhere"
    }

    override fun getItemCount(): Int {
        return 20
    }
}


