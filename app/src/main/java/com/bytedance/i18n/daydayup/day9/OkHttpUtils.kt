package com.bytedance.i18n.daydayup.day9

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

object OkHttpUtils {

    private val okHttpClient by lazy {
        OkHttpClient()
    }

    private val gson by lazy {
        Gson()
    }

    fun getSync(url: String):Response{
        val request = Request.Builder()
            .get()
            .header("Accept","application/json")
            .url(url)
            .build()

        return okHttpClient.newCall(request).execute()
    }

    fun <T> fromJson(json: String?, clazz: Class<T>): T{
        return gson.fromJson(json, clazz)
    }

}