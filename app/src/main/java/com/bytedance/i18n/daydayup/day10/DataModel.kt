package com.bytedance.i18n.daydayup.day10

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataModel : ViewModel() {

    var relatedData : MutableLiveData<List<Data>> = MutableLiveData()

    fun getData(){
        var data = ArrayList<Data>()
        relatedData.postValue(data)
    }
}