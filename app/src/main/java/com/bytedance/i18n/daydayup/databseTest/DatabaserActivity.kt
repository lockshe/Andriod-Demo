package com.bytedance.i18n.daydayup.databseTest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.bytedance.i18n.daydayup.R

class DatabaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rec_activity_layout)
        val db = Room.databaseBuilder(applicationContext, AppDataBase::class.java, "yzj_test_database").build()
//
//        db.userDao().insertAll(User(0, "young", "ziji"), User(1,"edward","zh"))
//        db.userDao().getAll().forEach {Log.d("yzjjjj",it.toString())}
    }


}