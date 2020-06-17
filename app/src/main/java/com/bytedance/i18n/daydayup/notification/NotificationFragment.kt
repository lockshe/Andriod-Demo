package com.bytedance.i18n.daydayup.notification

import android.app.NotificationManager
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bytedance.i18n.daydayup.R
import kotlinx.android.synthetic.main.notification_fragment.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NotificationFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.notification_fragment, container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            NotificationUtils.managerCompat = NotificationManagerCompat.from(it)
        }


        send_notification.setOnClickListener{
//            CoroutineScope(Dispatchers.IO).launch {
////                withContext(Dispatchers.IO) {
////                    Intent(activity, NotificationService::class.java).let {
////                        //序列化数据之后放intent里面
//////                        it.putParcelableArrayListExtra("trends", trends.toArrayList())
////                        activity?.let {
////                                activity ->
////                            ContextCompat.startForegroundService(activity, it)
////                        }
////                    }
////                }
//
//            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationUtils.createTrendsNotificationChannel(TrendsNotificationBuilder.HIGH_LEVEL, TrendsNotificationBuilder.HIGH_LEVEL, NotificationManager.IMPORTANCE_DEFAULT)
            }

            Intent(activity, NotificationService::class.java).let {
                //序列化数据之后放intent里面
//                        it.putParcelableArrayListExtra("trends", trends.toArrayList())
                activity?.let {
                        activity -> ContextCompat.startForegroundService(activity, it)
                }
            }
        }

        close_notification.setOnClickListener{

        }

    }

}