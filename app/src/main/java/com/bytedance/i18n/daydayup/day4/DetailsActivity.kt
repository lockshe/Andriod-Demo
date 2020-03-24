package com.bytedance.i18n.daydayup.day4

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import java.util.*

class DetailsActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment? {
        return DetailsFragment()
    }

    companion object {
        const val EXTRA_JOJO_ID = "yangziji@bytedance.com"
        fun newIntent(context: Context?, jojoId: UUID?): Intent {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(EXTRA_JOJO_ID, jojoId)
            return intent
        }
    }
}