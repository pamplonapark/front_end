package com.example.pamplonapark

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import androidx.room.Room
import com.example.pamplonapark.database.DatabaseManager
import com.example.pamplonapark.interfaces.LoginActivity
import com.example.pamplonapark.interfaces.SignupActivity

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


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Button navigation */
        botIniciarSesion = findViewById(R.id.iniciarSesion)
        botIniciarSesion.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            this.finish()
        }

        botRegistrarse = findViewById(R.id.registrarse)
        botRegistrarse.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
            this.finish()
        }
    }

    override fun finish() {
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            super.finish()
        }, 1500)

    }
}