package com.bytedance.i18n.daydayup.notification

import android.app.Notification
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationManagerCompat

class NotificationService : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        initNotification()

    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        startForeground(TrendsNotificationBuilder.CHANNEL_ID, TrendsNotificationBuilder(this).build())
        return START_STICKY
    }

    private fun initNotification(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationUtils.createTrendsNotificationChannel(TrendsNotificationBuilder.HIGH_LEVEL, TrendsNotificationBuilder.HIGH_LEVEL, NotificationManager.IMPORTANCE_DEFAULT)
        }
    }

}