package com.bytedance.i18n.daydayup.day7

class WeatherModel {

    var status = ""
    var temperature = 0.0
    var humidity = 0.0
    var cloudrate = 0.0
    var visibility = 0.0
    var wind:Wind? = null

    override fun toString(): String {
        return "WeatherModel(status='$status', temperature=$temperature, humidity=$humidity, cloudrate=$cloudrate, visibility=$visibility)"
    }


}