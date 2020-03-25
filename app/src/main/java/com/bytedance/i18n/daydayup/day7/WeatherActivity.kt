package com.bytedance.i18n.daydayup.day7

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bytedance.i18n.daydayup.R
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class WeatherActivity : AppCompatActivity(),CoroutineScope by MainScope() {

    lateinit var queryBt: Button
    lateinit var weatherText: TextView
    private val url = "https://api.caiyunapp.com/v2/TAkhjf8d1nlSlspN/121.6544,25.1552/realtime.json"
    private var http: OkHttpClient = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        queryBt = findViewById(R.id.queryBt)
        weatherText = findViewById(R.id.weather_details)
        queryBt.setOnClickListener{
            sendMessage()
        }
    }

    private fun sendMessage(){

        launch{
            var data = async {
                getData()
            }

            var result = data.await()
            weatherText.text = "get $result"
        }
    }

    // fuction to send http request
    suspend fun getData():String{
        var request:Request = Request.Builder()
            .get()
            .url(url)
            .build()

        var response:Response = http.newCall(request).execute()

        return response.message
    }

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }
}