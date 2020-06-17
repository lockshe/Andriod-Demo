package com.bytedance.i18n.daydayup.coordianteLayoutDemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bytedance.i18n.daydayup.R
import kotlinx.android.synthetic.main.view_pager_fragment.*

class ViewPagerFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.view_pager_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rec_view.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val adapter = MyAdapter()
        rec_view.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}

class MyAdapter: RecyclerView.Adapter<ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(TextView(parent.context))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder.itemView as TextView).apply {
            text = "position at ${position}"
            layoutParams = ViewGroup.LayoutParams(400, 400)
        }
    }

    override fun getItemCount(): Int {
        return 20
    }
}
