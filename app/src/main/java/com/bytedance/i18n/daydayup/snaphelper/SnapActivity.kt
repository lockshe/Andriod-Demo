package com.bytedance.i18n.daydayup.snaphelper

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.*
import com.bytedance.i18n.daydayup.R
import kotlinx.android.synthetic.main.activity_rec_snap.*

class SnapActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rec_snap)
        val adapter = SnapAdapter()
        page_rec_view.adapter = adapter
        page_rec_view.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.HORIZONTAL, false)

        linear_rec_view.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(applicationContext, RecyclerView.HORIZONTAL, false)
        }

        val linearHelper = LinearSnapHelper()
        val pageHelper = PagerSnapHelper()
        linearHelper.attachToRecyclerView(page_rec_view)
        pageHelper.attachToRecyclerView(linear_rec_view)
    }
}

class SnapHolder(itemView: SnapView) : RecyclerView.ViewHolder(itemView){

}

class SnapAdapter: RecyclerView.Adapter<SnapHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SnapHolder {
        return SnapHolder(SnapView(parent.context))
    }

    override fun onBindViewHolder(holder: SnapHolder, position: Int) {
        (holder.itemView as SnapView).bindData(String.format("see you %s", position.toString()))
        //String.format("see you %s", position.toString())
    }

    override fun getItemCount(): Int {
        return 20
    }


}

class SnapListener : RecyclerView.OnScrollListener(){

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
    }

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
    }


}

interface OnSnapPositionChanged