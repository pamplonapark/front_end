package com.example.pamplonapark.interfaces

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.room.Room
import com.example.pamplonapark.MainActivity
import com.example.pamplonapark.R
import com.example.pamplonapark.database.DatabaseManager

/**
 * Activity for user registration.
 * This activity allows users to register in the application.
 */
class SignupActivity : AppCompatActivity() {

    /**
     * Method called when the activity is created.
     * UI components are initialized.
     *
     * @param savedInstanceState Previous instance data if exists.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        /*Button navigation*/
        val btnSignup = findViewById<View>(R.id.btnSignup)
        btnSignup.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
            this.finish()
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
}
