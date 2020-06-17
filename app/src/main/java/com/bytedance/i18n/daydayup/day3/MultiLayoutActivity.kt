package com.bytedance.i18n.daydayup.day3

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bytedance.i18n.daydayup.R
import com.bytedance.i18n.daydayup.day2.Params
import java.util.*

class MultiLayoutActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var adapter: RecyclerView.Adapter<*>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var paramsList: MutableList<Params>? =
        null

    override fun onCreate(savedInstanceState: Bundle?) {
        context = applicationContext
        super.onCreate(savedInstanceState)
        initData()
        setContentView(R.layout.activity_recycle)
        val choice = this.intent.getIntExtra("choice", 0)
        when (choice) {
            0 -> layoutManager = LinearLayoutManager(this)
            1 -> layoutManager = GridLayoutManager(this, 2, RecyclerView.HORIZONTAL, false)
            2 -> {
                val staggeredGridLayoutManager =
                    StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                layoutManager = staggeredGridLayoutManager
            }
            else -> {
            }
        }
        recyclerView = findViewById(R.id.my_recycler_view)
        recyclerView!!.layoutManager = layoutManager
        adapter = paramsList?.let { MultiLayoutAdapter(it) }
        recyclerView!!.setAdapter(adapter)
    }

    fun initData() {
        paramsList = ArrayList()
        paramsList!!.add(
            Params(
                R.drawable.jojo1,
                R.string.jojo1,
                R.string.score1
            )
        )
        paramsList!!.add(
            Params(
                R.drawable.jojo2,
                R.string.jojo2,
                R.string.score2
            )
        )
        paramsList!!.add(
            Params(
                R.drawable.jojo3,
                R.string.jojo3,
                R.string.score3
            )
        )
        paramsList!!.add(
            Params(
                R.drawable.jojo4,
                R.string.jojo4,
                R.string.score4
            )
        )
        paramsList!!.add(
            Params(
                R.drawable.jojo5,
                R.string.jojo5,
                R.string.score5
            )
        )
        paramsList!!.add(
            Params(
                R.drawable.jojo6,
                R.string.jojo6,
                R.string.score6
            )
        )
    }

    companion object {
        var context: Context? = null
            private set
    }
}