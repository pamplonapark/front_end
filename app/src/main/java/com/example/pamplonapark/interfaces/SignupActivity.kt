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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
    private lateinit var registerButton : Button
    private lateinit var email : EditText
    private lateinit var username : EditText
    private lateinit var password : EditText
    private lateinit var password_conf : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        registerButton = findViewById(R.id.btnSignup);
        email = findViewById(R.id.editTextEmail);
        username = findViewById(R.id.editTextPhone);
        password = findViewById(R.id.editTextPassword);
        password_conf = findViewById(R.id.editTextPwdConfirmation);

        registerButton.setOnClickListener {
            if(!isBlankOrEmpty(email.text.toString()) || !isBlankOrEmpty(username.text.toString()))
            {
                if((!isBlankOrEmpty(password.text.toString()) || !isBlankOrEmpty(password_conf.text.toString())) && password_conf.text.toString().equals(password.text.toString()))
                {
                    var password_encrypted = Crypto().encryptPassword(password.text.toString());
                    CoroutineScope(Dispatchers.Main).launch {
                        val success = ServerManager.registerUser(
                            username.text.toString(),
                            email.text.toString(),
                            password_encrypted
                        )
                        if (success.get("status") == true) {
                            Toast.makeText(
                                this@SignupActivity,
                                "Te has registrado correctamente",
                                Toast.LENGTH_SHORT
                            ).show()
                            val intent = Intent(this@SignupActivity, SearchActivity::class.java);
                            intent.putExtra("username", username.text.toString());

                            startActivity(intent)
                            this@SignupActivity.finish()
                        } else {
                            Toast.makeText(
                                this@SignupActivity,
                                "No se pudo crear el usuario",
                                //success.get("message").toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } else Toast.makeText(this, "Rellena todos los campos y las contraseñas deben coincidir", Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(this, "Rellena todos los campos por favor", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun isBlankOrEmpty(input: String): Boolean {
        return input.isBlank() || input.isEmpty()
    }
}
