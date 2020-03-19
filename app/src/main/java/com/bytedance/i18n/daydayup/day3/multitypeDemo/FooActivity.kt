package com.bytedance.i18n.daydayup.day3.multitypeDemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bytedance.i18n.daydayup.R
import com.bytedance.i18n.daydayup.day3.MultiLayoutAdapter
import com.drakeet.multitype.MultiTypeAdapter
import kotlinx.android.synthetic.main.activity_recycle.view.*

class FooActivity: AppCompatActivity(){

    private val adapter = MultiTypeAdapter()
    private val items = ArrayList<Int>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle)

        val recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view)
        adapter.register(FooViewDelegate())
        items.add(R.drawable.jojo1)
        items.add(R.drawable.jojo2)
        items.add(R.drawable.jojo3)
        items.add(R.drawable.jojo4)
        items.add(R.drawable.jojo5)
        items.add(R.drawable.jojo6)
        adapter.items = items;
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}