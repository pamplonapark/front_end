package com.example.pamplonapark.dataModels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Class representing a user in the PamplonaPark database.
 *
 * @param username The username of the user.
 * @param token The authentication token of the user.
 */
@Entity(tableName = "Users")
data class User(
    @PrimaryKey @ColumnInfo(name = "username") val username: String = "",
    @ColumnInfo(name = "token") val token: String,
)
