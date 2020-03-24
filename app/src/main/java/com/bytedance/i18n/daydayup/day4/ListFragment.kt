package com.bytedance.i18n.daydayup.day4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bytedance.i18n.daydayup.R
import com.bytedance.i18n.daydayup.day2.MovieInfoView
import com.bytedance.i18n.daydayup.day2.Params
import com.google.gson.Gson
import java.util.*

class ListFragment : Fragment() {
    private var recyclerView: RecyclerView? = null
    private var adapter: ListViewAdapter? = null
    private var paramsList: MutableList<Params>? =
        null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_recycle, container, false)
        recyclerView = view.findViewById<View>(R.id.my_recycler_view) as RecyclerView
        recyclerView!!.layoutManager = LinearLayoutManager(activity)
        updateUI()
        return view
    }

    private fun updateUI() {
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
        adapter = ListViewAdapter(paramsList as ArrayList<Params>)
        recyclerView!!.adapter = adapter
    }

    private inner class ListViewHolder(view: View) :
        RecyclerView.ViewHolder(view), View.OnClickListener {
        val movieInfoView: MovieInfoView
        override fun onClick(v: View) { //            Toast.makeText(getActivity(), "laban", Toast.LENGTH_SHORT).show()；
//            这种写法是两个activity进行跳转
//            Intent intent = new Intent(getActivity(), DetailsActivity.class);
//            intent.putExtra("params", new Gson().toJson(paramsList.get(movieInfoView.getIndex())));
//            startActivity(intent);
            val detailsFragment = DetailsFragment()
            val args = Bundle()
            args.putString("params", Gson().toJson(paramsList!![movieInfoView.index]))
            detailsFragment.arguments = args
            val transaction =
                activity!!.supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, detailsFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        init {
            movieInfoView = view as MovieInfoView
            movieInfoView.setOnClickListener(this)
        }
    }

    private inner class ListViewAdapter(private val paramsList: List<Params>) :
        RecyclerView.Adapter<ListViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
            return ListViewHolder(MovieInfoView(parent.context))
        }

        override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
            holder.movieInfoView.bindData(paramsList[position], position)
        }

        override fun getItemCount(): Int {
            return paramsList.size
        }

    }
}