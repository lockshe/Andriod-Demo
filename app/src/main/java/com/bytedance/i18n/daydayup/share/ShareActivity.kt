package com.bytedance.i18n.daydayup.share

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bytedance.i18n.daydayup.R
import kotlinx.android.synthetic.main.share_activity.*

class ShareActivity:AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.share_activity)
        share.setOnClickListener {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT,"hello zi ji")
            sendIntent.setType("text/plain")
            startActivity(Intent.createChooser(sendIntent, "Share to........"))
        }
    }

}