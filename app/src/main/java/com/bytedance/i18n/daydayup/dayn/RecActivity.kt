package com.bytedance.i18n.daydayup.dayn

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bytedance.i18n.daydayup.R
import kotlinx.android.synthetic.main.rec_activity_layout.*

class RecActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rec_activity_layout)
        val adapter = RecAdapter(arrayListOf(1, 2, 3, 4, 5, 6, 7, 2,2))
        rec_view.adapter = adapter
        rec_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rec_view.itemAnimator = null
        adapter.notifyDataSetChanged()
    }
}

