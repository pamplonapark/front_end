package com.example.pamplonapark.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.pamplonapark.dataModels.User

/**
 * Data Access Object (DAO) for the user entity.
 * This DAO provides methods to perform CRUD (Create, Read, Update, Delete) operations
 * on the user table in the database.
 */
@Dao
interface UserDAO {
    /**
     * Gets a user by their username.
     *
     * @param username The username of the user to be retrieved.
     * @return The found user or null if no user was found with the given username.
     */
    @Query("SELECT * FROM Users WHERE username = :username")
    fun getUserByUsername(username: String): User?

    /**
     * Inserts a new user into the database.
     *
     * @param user The user to be inserted.
     */
    @Insert
    fun insert(user: User)

    /**
     * Deletes a user from the database.
     *
     * @param user The user to be deleted.
     */
    @Delete
    fun delete(user: User)

    /**
     * Updates an existing user in the database.
     *
     * @param user The user to be updated.
     */
    @Update
    fun update(user: User)
}
