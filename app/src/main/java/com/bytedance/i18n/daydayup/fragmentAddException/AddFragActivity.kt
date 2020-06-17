package com.bytedance.i18n.daydayup.fragmentAddException

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bytedance.i18n.daydayup.R

class AddFragActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_frag_activity)
        val fragment = supportFragmentManager.findFragmentById(R.id.container)

        fragment?.let {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, it)
                .commit()
        }

    }

}