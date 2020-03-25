package com.bytedance.i18n.daydayup.day7

import android.content.Context
import android.os.Bundle
import android.util.JsonReader
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.appcompat.app.AppCompatActivity
import com.bytedance.i18n.daydayup.R
import com.google.gson.Gson
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject

class WeatherActivity : AppCompatActivity(),CoroutineScope by MainScope() {

    lateinit var queryBt: Button
    lateinit var statusText: TextView
    lateinit var tempText: TextView
    lateinit var humidText: TextView
    lateinit var cloudText: TextView
    lateinit var visibilityText: TextView
    lateinit var speedText: TextView
    lateinit var directionText: TextView

    lateinit var longitude: EditText
    lateinit var latitude:EditText

    private var http: OkHttpClient = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        queryBt = findViewById(R.id.queryBt)
        statusText = findViewById(R.id.status)
        tempText = findViewById(R.id.temp)
        humidText = findViewById(R.id.humidity)
        cloudText = findViewById(R.id.cloudrate)
        visibilityText = findViewById(R.id.visi)
        speedText = findViewById(R.id.speed)
        directionText = findViewById(R.id.direction)
        longitude = findViewById(R.id.longtitude)
        latitude = findViewById(R.id.latitude)

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
            if (result != null) {
                updateUI(result)
            }else{
                makeText(application.applicationContext, "input Error!", Toast.LENGTH_SHORT)
            }
        }
    }

    // fuction to send http request
    suspend fun getData() = withContext(Dispatchers.IO){

        val url = "https://api.caiyunapp.com/v2/TAkhjf8d1nlSlspN/${longitude.text},${latitude.text}/realtime.json"

        var request:Request = Request.Builder()
            .get()
            .url(url)
            .build()

        var response:Response = http.newCall(request).execute()
        var gson = Gson()
        var data :ResponseData = gson.fromJson(
            response.body?.string(), ResponseData::class.java)

        data.result
    }


    private fun updateUI(data: WeatherModel){
        statusText.text = data.status
        tempText.text = "${data.temperature} 度"
        humidText.text = "${data.humidity}"
        cloudText.text = "${data.cloudrate} L"
        visibilityText.text = "${data.visibility}"
        speedText.text = "${data.wind?.speed} m/s"
        directionText.text = "${data.wind?.direction}"
    }

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }

}