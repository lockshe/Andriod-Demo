package com.bytedance.i18n.daydayup.databseTest

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Query("select * from user")
    fun getAll(): List<User>

    @Insert
    fun insertAll(vararg users: User)

    @Delete()
    fun delete(user: User)

    @Query("select * from user where uid in (:userIds)")
    fun loadAllByIds(userIds: IntArray):List<User>

    @Query("select * from user where first_name like :first and last_name like :last")
    fun findByName(first: String, last: String): User
}