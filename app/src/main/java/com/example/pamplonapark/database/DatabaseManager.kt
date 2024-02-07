package com.example.pamplonapark.database
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pamplonapark.dao.UserDAO
import com.example.pamplonapark.dataModels.User

@Database(entities = [User::class], version = 1)
abstract class DatabaseManager : RoomDatabase() {
    abstract fun userDao(): UserDAO

    companion object{
        private const val database_name = "pamplonapark_db";

        @Volatile
        private var INSTANCE : DatabaseManager? = null;

        fun getInstance(context: Context) : DatabaseManager
        {
            synchronized(this)
            {
                var instance = INSTANCE;

                if(instance == null)
                {
                    instance = Room.databaseBuilder(context.applicationContext, DatabaseManager::class.java, database_name).build();
                    INSTANCE = instance;
                }

                return instance;
            }
        }
    }
}