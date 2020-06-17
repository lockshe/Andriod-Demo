package com.bytedance.i18n.daydayup.notification

import android.app.Notification
import android.content.Context
import android.widget.RemoteViews
import android.widget.TextView
import androidx.core.app.NotificationCompat
import com.bytedance.i18n.daydayup.R


class TrendsNotificationBuilder(val context: Context) {


    val list = listOf("aaaa","bbbb","ccccc","dddd", "eeeee", "ffffff", "ggggg","hhhhhh")

    companion object{

        const val HIGH_LEVEL = "high_level"

        const val DEFAULT_LEVEL = "default_level"

        const val LOW_LEVEL = "low_level"

        const val CHANNEL_ID = 100
    }

    fun build(): Notification{
        return NotificationCompat.Builder(context, HIGH_LEVEL).apply {
            setSmallIcon(R.drawable.ic_add_alert_black_24dp)
            setOngoing(true)
            setSound(null)
            setCustomContentView(buildCustomView())
            setCustomHeadsUpContentView(buildCustomView())
            setCustomBigContentView(buildCustomView())
        }.build()

    }

    fun buildCustomView():RemoteViews{
        return buildParentView().also{ parent ->
            list.chunked(2).forEach{
                    list -> bindItemData(list, parent)
            }
        }
    }

    //use pa
    fun bindItemData(list: List<String>, parentView:RemoteViews){
        parentView.addView(R.id.notification_container, buildItemView().apply {
            setTextViewText(R.id.text1, list[0])
            setTextViewText(R.id.text2, list[1])
        })
    }

    //linealayout add view
    fun buildParentView():RemoteViews{
        return RemoteViews(context.packageName, R.layout.notification_layout)
    }

    //each raw with 2 item
    fun buildItemView():RemoteViews{
        return RemoteViews(context.packageName, R.layout.notification_view_layout)
    }


}