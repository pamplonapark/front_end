package com.example.pamplonapark.interfaces

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room
import com.example.pamplonapark.MainActivity
import com.example.pamplonapark.R
import com.example.pamplonapark.database.DatabaseManager
import com.example.pamplonapark.internal_code.Crypto
import com.example.pamplonapark.internal_code.ServerManager

/**
 * Login activity.
 * This activity allows users to log in or register in the application.
 */
class LoginActivity : AppCompatActivity() {
    private lateinit var botRegistrarse: Button
    private lateinit var usuario : EditText
    private lateinit var contra : EditText
    private lateinit var btnRegister : Button

    /**
     * Method called when the activity is created.
     * UI components are initialized and listeners are set up.
     *
     * @param savedInstanceState Previous instance data if exists.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usuario = findViewById(R.id.usuario)
        contra = findViewById(R.id.contra)
        botRegistrarse = findViewById(R.id.btnLogin)
        btnRegister = findViewById(R.id.btnRegister)

        botRegistrarse.setOnClickListener {
            if(!isBlankOrEmpty(usuario.text.toString()) || !isBlankOrEmpty(contra.text.toString()))
            {
                var password_encrypted = Crypto().encryptPassword(contra.text.toString());
                ServerManager.loginUser(usuario.text.toString(), password_encrypted);

                Toast.makeText(this, "Has iniciado sesión correctamente", Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(this, "Rellena todos los campos por favor", Toast.LENGTH_SHORT).show()
            }
        }

        btnRegister.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
            this.finish()
        }
    }

    fun isBlankOrEmpty(input: String): Boolean {
        return input.isBlank() || input.isEmpty()
    }
}
