package com.bytedance.i18n.daydayup.databseTest

import android.content.Context
import android.database.Observable
import androidx.room.Database
import androidx.room.RoomDatabase
import java.util.*

@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDataBase : RoomDatabase() {

//
//    companion object{
//
//        var database: AppDataBase? =null
//
//        fun getAppDataBase(context: Context):AppDataBase?{
//
//
//
//        }
//    }
//

    abstract fun userDao(): UserDao
}