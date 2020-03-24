package com.bytedance.i18n.daydayup.day4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bytedance.i18n.daydayup.R
import com.bytedance.i18n.daydayup.day2.Params
import com.google.gson.Gson

class DetailsFragment : Fragment() {
    var imageView: ImageView? = null
    var textView: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_details, container, false)
        imageView = view.findViewById(R.id.jojoname)
        textView = view.findViewById(R.id.jojotext)
        //      从activity中取数据
//        Params params = new Gson().fromJson(getActivity().getIntent().getStringExtra("params"), Params.class);
        val params =
            Gson().fromJson(
                arguments!!.getString("params"),
                Params::class.java
            )
        imageView!!.setImageResource(params.imgSrc)
        textView!!.setText(params.titleText)
        return view
    }
}