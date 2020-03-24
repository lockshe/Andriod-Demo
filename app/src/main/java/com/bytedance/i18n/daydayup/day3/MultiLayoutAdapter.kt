package com.bytedance.i18n.daydayup.day3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bytedance.i18n.daydayup.R
import com.bytedance.i18n.daydayup.day2.MovieInfoView
import com.bytedance.i18n.daydayup.day2.Params
import com.bytedance.i18n.daydayup.day3.MultiLayoutActivity

class MultiLayoutAdapter(private val paramsList: MutableList<Params>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val movieInfoView: MovieInfoView

        init {
            movieInfoView = v as MovieInfoView
        }
    }

    class SecondViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private val imageView: ImageView
        private val imageView2: ImageView
        private val imageView3: ImageView
        fun bindData(params: Params) {
            imageView.setImageResource(params.imgSrc)
            imageView2.setImageResource(params.imgSrc)
            imageView3.setImageResource(params.imgSrc)
        }

        init {
            imageView = v.findViewById(R.id.sec_lay_img)
            imageView2 = v.findViewById(R.id.sec_lay_img2)
            imageView3 = v.findViewById(R.id.sec_lay_img3)
        }
    }

    class ThridViewHolder(v: View?) : RecyclerView.ViewHolder(v!!)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder{
        val v: View
        val vh: RecyclerView.ViewHolder
        return when (viewType) {
            FIRST_LAYOUT -> {
                v = MovieInfoView(parent.context)
                vh = MyViewHolder(v)
                vh
            }
            SECOND_LAYOUT -> {
                v = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_second_view, parent, false)
                vh = SecondViewHolder(v)
                vh
            }
            else -> {
                v = MovieInfoView(parent.context)
                vh = MyViewHolder(v)
                vh
            }
        }
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        if (holder is MyViewHolder) {
            holder.movieInfoView.bindData(
                paramsList[position],
                position
            )
        } else if (holder is SecondViewHolder) {
            holder.bindData(paramsList[position])
        }
        holder.itemView.setOnClickListener {
            Toast.makeText(
                MultiLayoutActivity.context,
                "you are in the position $position now",
                Toast.LENGTH_SHORT
            ).show()
            removeData(position)
        }
        holder.itemView.setOnLongClickListener {
            addData(position)
            true
        }
    }

    override fun getItemCount(): Int {
        return paramsList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (position <= 2) {
            FIRST_LAYOUT
        } else {
            SECOND_LAYOUT
        }
    }

    fun addData(position: Int) {
        paramsList.add(
            Params(
                R.drawable.jojo6,
                R.string.jojo6,
                R.string.score6
            )
        )
        notifyItemInserted(position)
    }

    fun removeData(position: Int) {
        paramsList.removeAt(position)
        notifyItemRemoved(position)
    }

    fun updateData(position: Int) {}

    companion object {
        private const val FIRST_LAYOUT = 1
        private const val SECOND_LAYOUT = 2
        private const val THIRD_LAYOUT = 3
    }

}