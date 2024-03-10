package com.example.pamplonapark.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pamplonapark.dao.UserDAO
import com.example.pamplonapark.dataModels.User

/**
 * Class acting as the main database for the PamplonaPark application.
 * This class is responsible for providing a singleton instance of the database and
 * contains an abstract method to access the user DAO.
 *
 * @param entities Array of entity classes representing the database tables.
 * @param version Database version.
 */
@Database(entities = [User::class], version = 1)
abstract class DatabaseManager : RoomDatabase() {

    /**
     * Abstract method to access the user DAO.
     *
     * @return The instance of the user DAO.
     */
    abstract fun userDao(): UserDAO

    companion object {
        private const val database_name = "pamplonapark_db"

        @Volatile
        private var INSTANCE: DatabaseManager? = null

        /**
         * Obtains a singleton instance of the database.
         *
         * @param context The application context.
         * @return The database instance.
         */
        fun getInstance(context: Context): DatabaseManager {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DatabaseManager::class.java,
                        database_name
                    ).build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}
