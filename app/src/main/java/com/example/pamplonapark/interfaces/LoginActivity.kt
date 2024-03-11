package com.example.pamplonapark.interfaces

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.pamplonapark.MainActivity
import com.example.pamplonapark.R
import com.example.pamplonapark.dao.UserDAO
import com.example.pamplonapark.dataModels.User
import com.example.pamplonapark.database.DatabaseManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Login activity.
 * This activity allows users to log in or register in the application.
 */
class LoginActivity : AppCompatActivity() {
    private lateinit var botRegistrarse: Button
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText

    /**
     * Method called when the activity is created.
     * UI components are initialized and listeners are set up.
     *
     * @param savedInstanceState Previous instance data if exists.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameEditText = findViewById(R.id.usuario)
        passwordEditText = findViewById(R.id.contra)

        val btnConfirm = findViewById<View>(R.id.btnLogin)
        btnConfirm.setOnClickListener {
            login()
        }

        botRegistrarse = findViewById(R.id.btnRegister)
        botRegistrarse.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
            this.finish()
        }
    }

    /**
     * Method called when it's requested for the activity to finish.
     * Redirects the user to the main activity after a brief delay.
     */
    override fun finish() {
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            super.finish()
        }, 1500)
    }

    private fun login() {
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()

        if (username.isNotEmpty() && password.isNotEmpty()) {
            // Obtener una instancia de la base de datos Room
            val database = DatabaseManager.getInstance(this)

            // Obtener el DAO de usuario
            val userDAO: UserDAO = database.userDao()

            GlobalScope.launch(Dispatchers.IO) {
                // Buscar el usuario en la base de datos
                val user = userDAO.getUserByUsername(username)

                // Verificar si el usuario existe y si la contraseña coincide
                if (user != null && user.token == password) {
                    // Usuario autenticado, redirigir al MainActivity
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    finish()
                } else {
                    // Usuario no encontrado o contraseña incorrecta
                    showToast("Usuario o contraseña incorrectos")
                }
            }
        } else {
            showToast("Por favor, ingrese su usuario y contraseña")
        }
    }

    private fun showToast(message: String) {
        GlobalScope.launch(Dispatchers.Main) {
            Toast.makeText(this@LoginActivity, message, Toast.LENGTH_SHORT).show()
        }
    }
}
