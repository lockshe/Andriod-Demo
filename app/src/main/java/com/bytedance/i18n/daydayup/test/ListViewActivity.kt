package com.bytedance.i18n.daydayup.test

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.bytedance.i18n.daydayup.R
import kotlinx.android.synthetic.main.activity_listview.*


class ListViewActivity: AppCompatActivity() {

    private var data = arrayOf("Jonathan Joestar", "Joseph Joestar", "Kujo Jotaro", "Higashikata Josuke")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)

        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)
        list_view.adapter = adapter

    }
}