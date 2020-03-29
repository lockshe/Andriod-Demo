package com.bytedance.i18n.daydayup.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bytedance.i18n.daydayup.R

import kotlinx.android.synthetic.main.msg_item.view.*

class MsgAdapter(private val list: ArrayList<Msg>) : RecyclerView.Adapter<MsgAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.msg_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var msg = list[position]

        if (msg.type == Msg.TYPE_REVEIVED){
            holder.itemView.left_layout.visibility = View.VISIBLE
            holder.itemView.right_layout.visibility = View.GONE
            holder.itemView.left_msg.text = msg.content
        }else if (msg.type == Msg.TYPE_SENT){
            holder.itemView.right_layout.visibility = View.VISIBLE
            holder.itemView.left_layout.visibility = View.GONE
            holder.itemView.right_msg.text = msg.content
        }
    }

}