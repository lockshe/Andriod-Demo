package com.bytedance.i18n.daydayup.day9

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bytedance.i18n.daydayup.R
import com.bytedance.i18n.daydayup.day7.ResponseData
import com.bytedance.i18n.daydayup.day7.WeatherModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_weather.*
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class WeatherPlusActivity: AppCompatActivity(), CoroutineScope by MainScope(){


    private val REQUEST_LOCATION_PERMISSION_CODE = 1
    private var mGpsListener = MyLocationListener()
    private lateinit var model: WeatherViewModel


    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.size > 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED
        ) {
            bindLocationListener()
        } else {
            Toast.makeText(this, "Query Weather requires Location access", Toast.LENGTH_LONG).show()
        }
    }

    private fun bindLocationListener() {
        BoundLocationManager.bindLocationListenerIn(this, mGpsListener, applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_plus)
        model = ViewModelProviders.of(this).get(WeatherViewModel::class.java)

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this, arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                REQUEST_LOCATION_PERMISSION_CODE
            )
        } else {
            bindLocationListener()
        }

        model.weatherData.observe(this, Observer<WeatherModel>{
            Log.d("info","data changed! UpdateUI")
            updateUI()
        })
        sendMessage()
    }

    private fun sendMessage(){
        launch{
            var data = async {
                getData()
            }

            data.await()?.let {
                model.weatherData.postValue(it)
            }
        }

    }

    // fuction to send http request
    suspend fun getData() = withContext(Dispatchers.IO){
        val url = "https://api.caiyunapp.com/v2/TAkhjf8d1nlSlspN/${longti.text},${lati.text}/realtime.json"
        Log.d("info", url)

        var response: Response = OkHttpUtils.getSync(url)
        var data : ResponseData = OkHttpUtils.fromJson(response.body?.string(), ResponseData::class.java)
        Log.d("info", data.result.toString())
        data.result
    }


    private fun updateUI(){
        val data = model.weatherData.value
        if (data != null){
            status.text = data.status
            temp.text = "${data.temperature} 度"
            humidity.text = "${data.humidity}"
            cloudrate.text = "${data.cloudrate} L"
            visi.text = "${data.visibility}"
            speed.text = "${data.wind?.speed} m/s"
            direction.text = "${data.wind?.direction}"


//            if (data.temperature >= 15){
//                ZiJiWeather.setBackgroundResource(R.drawable.sunny2)
//            }else if (data.humidity >= 0.9){
//                ZiJiWeather.setBackgroundResource(R.drawable.rainy)
//            }else if (data.cloudrate >= 0.5 && data.temperature < 20){
//                ZiJiWeather.setBackgroundResource(R.drawable.cloudy)
//            }else if (data.temperature < 10){
//                ZiJiWeather.setBackgroundResource(R.drawable.snowy)
//            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }


    inner class MyLocationListener : LocationListener {
        override fun onLocationChanged(location: Location) {
            lati.text = location.latitude.toString()
            longti.text = location.longitude.toString()
        }

        override fun onStatusChanged(
            provider: String,
            status: Int,
            extras: Bundle
        ) {
        }

        override fun onProviderEnabled(provider: String) {
            Toast.makeText(
                this@WeatherPlusActivity,
                "Provider enabled: $provider", Toast.LENGTH_SHORT
            ).show()
        }

        override fun onProviderDisabled(provider: String) {}
    }
}