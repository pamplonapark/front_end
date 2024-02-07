package com.example.pamplonapark.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.pamplonapark.dataModels.User

@Dao
interface UserDAO
{
    @Query("SELECT * FROM Users WHERE username = :username")
    fun getUserByUsername(username : String) : User;

    @Insert
    fun insert(user: User)

    @Delete
    fun delete(user: User)

    @Update
    fun update(user: User)
}