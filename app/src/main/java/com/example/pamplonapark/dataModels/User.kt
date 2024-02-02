package com.example.pamplonapark.dataModels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class User(
    @PrimaryKey @ColumnInfo(name = "username") val username: String = "",
    @ColumnInfo(name = "token") val token: String,
)