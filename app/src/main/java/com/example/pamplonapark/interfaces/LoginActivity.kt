package com.example.pamplonapark.interfaces

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import androidx.room.Room
import com.example.pamplonapark.MainActivity
import com.example.pamplonapark.R
import com.example.pamplonapark.database.DatabaseManager

/**
 * Login activity.
 * This activity allows users to log in or register in the application.
 */
class LoginActivity : AppCompatActivity() {
    private lateinit var botRegistrarse: Button

    /**
     * Method called when the activity is created.
     * UI components are initialized and listeners are set up.
     *
     * @param savedInstanceState Previous instance data if exists.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        /*Button navigation
        *btnConfirm debería chekear en la bd si el usuario existe y dirigirte a la activity SearchActivity con la lista de parkings
        *botRegistrarse te lleva a la activity SignUpActivity gracias al metodo finish1() para registrarte*/

        val btnConfirm = findViewById<View>(R.id.btnLogin)
        btnConfirm.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
            this.finish()
        }

        botRegistrarse = findViewById(R.id.btnRegister)
        botRegistrarse.setOnClickListener {
            this.finish1()
        }
    }

    /**
     * Method called when it's requested for the activity to finish.
     * Redirects the user to the main activity after a brief delay.
     */
    override fun finish() {
        startActivity(Intent(this, MainActivity::class.java))
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            super.finish()
        }, 1500)
    }

    /**
     * Method to finish the current activity and open the signup activity.
     * Used when the user clicks the "Register" button.
     */
    private fun finish1() {
        startActivity(Intent(this, SignupActivity::class.java))
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            super.finish()
        }, 1500)
    }
}
