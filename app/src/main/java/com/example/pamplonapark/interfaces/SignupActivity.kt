package com.example.pamplonapark.interfaces

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import com.example.pamplonapark.MainActivity
import com.example.pamplonapark.R
import org.json.JSONObject

/**
 * Activity for user registration.
 * This activity allows users to register in the application.
 */
class SignupActivity : AppCompatActivity() {
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPhone: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var editTextPwdConfirmation: EditText

    /**
     * Method called when the activity is created.
     * UI components are initialized and listeners are set up.
     *
     * @param savedInstanceState Previous instance data if exists.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPhone = findViewById(R.id.editTextPhone)
        editTextPassword = findViewById(R.id.editTextPassword)
        editTextPwdConfirmation = findViewById(R.id.editTextPwdConfirmation)
        val btnSignup = findViewById<Button>(R.id.btnSignup)

        btnSignup.setOnClickListener {
            signUp()
        }
    }

    /**
     * Method to handle user registration.
     * Verifies that all fields are filled and passwords match before constructing a JSON object.
     */
    private fun signUp() {
        val email = editTextEmail.text.toString()
        val phone = editTextPhone.text.toString()
        val password = editTextPassword.text.toString()
        val pwdConfirmation = editTextPwdConfirmation.text.toString()

        if (email.isNotEmpty() && phone.isNotEmpty() && password.isNotEmpty() && pwdConfirmation.isNotEmpty()) {
            if (password == pwdConfirmation) {
                // All fields are filled and passwords match
                val jsonObject = JSONObject()
                jsonObject.put("email", email)
                jsonObject.put("phone", phone)
                jsonObject.put("password", password)

                val jsonString = jsonObject.toString()
                println("JSON construido: $jsonString")

                // Additional actions can be performed here, such as sending the JSON object to a server or storing it locally.
                // For example, you could use Room to store the information in a local database.
            } else {
                println("Passwords do not match")
            }
        } else {
            println("Please fill in all fields")
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
