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
import com.example.pamplonapark.internal_code.ServerManager

/**
 * The main activity of the PamplonaPark application.
 * This activity serves as the entry point to the application and allows users to navigate to the login or signup screens.
 */
class MainActivity : AppCompatActivity() {
    // Button to navigate to the login screen
    private lateinit var botIniciarSesion: Button
    /*Button to navigate to the signup screen*/
    private lateinit var botRegistrarse: Button

    /* Static database initialization */
    companion object {
        // Instance of the Room database
        lateinit var database: DatabaseManager
            private set
    }

    /**
     * Called when the activity is first created.
     * Initializes the Room database, sets up button click listeners, and navigates to the appropriate screens.
     *
     * @param savedInstanceState Data from previous instance if exists.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        /* Room database initialization */
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

    /**
     * Called when the activity is finishing.
     * Adds a delay before finishing the activity to provide a smooth user experience.
     */
    override fun finish() {
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            super.finish()
        }, 1500)
    }
}
