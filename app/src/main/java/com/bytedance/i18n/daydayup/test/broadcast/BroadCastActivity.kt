package com.bytedance.i18n.daydayup.test.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bytedance.i18n.daydayup.R

class BroadCastActivity : AppCompatActivity() {

    private lateinit var intentFilter: IntentFilter
    private lateinit var netWorkChangeReceiver: NetWorkChangeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        intentFilter = IntentFilter()
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE")
        netWorkChangeReceiver = NetWorkChangeReceiver()
        registerReceiver(netWorkChangeReceiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(netWorkChangeReceiver)
    }

    class NetWorkChangeReceiver : BroadcastReceiver() {

        override fun onReceive(p0: Context?, p1: Intent?) {
            var connectionManager = p0?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            var netWorkInfo = connectionManager.activeNetworkInfo
            if (netWorkInfo != null && netWorkInfo.isConnected){
                Toast.makeText(p0, "network is available", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(p0, "network is unavailable", Toast.LENGTH_LONG).show()
            }
        }

    }

}