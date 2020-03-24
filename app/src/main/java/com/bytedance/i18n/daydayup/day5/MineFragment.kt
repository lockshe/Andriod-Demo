package com.bytedance.i18n.daydayup.day5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bytedance.i18n.daydayup.R

class MineFragment : Fragment() {
    var textView: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.layout_multi_frag, container, false)
        textView = view.findViewById(R.id.frag_text)
        textView!!.setText("Mine Page")
        return view
    }
}