package com.bytedance.i18n.daydayup.day9

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bytedance.i18n.daydayup.day7.ResponseData
import com.bytedance.i18n.daydayup.day7.WeatherModel

class WeatherViewModel : ViewModel() {

    var weatherData: MutableLiveData<WeatherModel> = MutableLiveData()

}