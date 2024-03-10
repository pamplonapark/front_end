package com.example.pamplonapark

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.room.Room
import com.example.pamplonapark.database.DatabaseManager
import com.example.pamplonapark.interfaces.LoginActivity
import com.example.pamplonapark.interfaces.SignupActivity
import com.example.pamplonapark.internal_code.ServerManager

class MainActivity : AppCompatActivity() {
    private lateinit var botIniciarSesion: Button
    private lateinit var botRegistrarse: Button

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

        ServerManager.getAllParkings();


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Button navigation */
        botIniciarSesion = findViewById(R.id.iniciarSesion)
        botIniciarSesion.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        botRegistrarse = findViewById(R.id.registrarse)
        botRegistrarse.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }
}