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
import com.example.pamplonapark.database.DatabaseManager
import com.example.pamplonapark.interfaces.SignupActivity
import org.json.JSONObject

/**
 * Login activity.
 * This activity allows users to log in or register in the application.
 */
class LoginActivity : AppCompatActivity() {
    private lateinit var usuarioEditText: EditText
    private lateinit var contraEditText: EditText

    /**
     * Method called when the activity is created.
     * UI components are initialized and listeners are set up.
     *
     * @param savedInstanceState Previous instance data if exists.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usuarioEditText = findViewById(R.id.usuario)
        contraEditText = findViewById(R.id.contra)
        val botRegistrarse: Button = findViewById(R.id.btnRegister)

        botRegistrarse.setOnClickListener {
            finish1()
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
        val usuario = usuarioEditText.text.toString()
        val contra = contraEditText.text.toString()

        if (usuario.isNotEmpty() && contra.isNotEmpty()) {
            // Ambos campos están completos, procedemos a construir el objeto JSON
            val jsonObject = JSONObject()
            jsonObject.put("usuario", usuario)
            jsonObject.put("contra", contra)

            // Ahora puedes usar el objeto JSON según tus necesidades
            val jsonString = jsonObject.toString()
            println("JSON construido: $jsonString")

            startActivity(Intent(this, SignupActivity::class.java))
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed({
                super.finish()
            }, 1500)
        } else {
            // Al menos uno de los campos está vacío, muestra un mensaje de error
            // o realiza alguna acción adecuada según tu lógica de aplicación
            println("Por favor, complete todos los campos")
        }
    }
}
