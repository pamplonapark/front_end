package com.example.pamplonapark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.pamplonapark.database.DatabaseManager

class MainActivity : AppCompatActivity() {
    /* Static database init */
    companion object {
        lateinit var database: DatabaseManager
            private set
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        /* Room init */
        database = Room.databaseBuilder(
            applicationContext,
            DatabaseManager::class.java, "pamplonapark_db"
        ).build();


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}