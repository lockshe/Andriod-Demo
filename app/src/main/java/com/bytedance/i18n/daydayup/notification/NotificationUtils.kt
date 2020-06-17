package com.bytedance.i18n.daydayup.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationManagerCompat

object NotificationUtils  {


    lateinit var managerCompat:NotificationManagerCompat

    @RequiresApi(Build.VERSION_CODES.O)
    fun getTrendsNotificationDefaultChannel(managerCompat: NotificationManagerCompat): NotificationChannel? {

        if (managerCompat.getNotificationChannel(TrendsNotificationBuilder.HIGH_LEVEL) == null) {
            createTrendsNotificationChannel(TrendsNotificationBuilder.HIGH_LEVEL, TrendsNotificationBuilder.HIGH_LEVEL, NotificationManager.IMPORTANCE_DEFAULT)
        }
        return managerCompat.getNotificationChannel(TrendsNotificationBuilder.HIGH_LEVEL)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun createTrendsNotificationChannel(channelId: String, channelName: String, importance: Int) {
        var channel = managerCompat.getNotificationChannel(channelId)
        if (channel == null) {
            channel = NotificationChannel(channelId, channelName, importance).apply {
                enableLights(false)
                enableVibration(false)
                setSound(null, null)
            }
            managerCompat.createNotificationChannel(channel)
        }
    }
}