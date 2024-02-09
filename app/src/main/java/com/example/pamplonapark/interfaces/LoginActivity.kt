package com.example.pamplonapark.interfaces

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.room.Room
import com.example.pamplonapark.MainActivity
import com.example.pamplonapark.R
import com.example.pamplonapark.database.DatabaseManager

class LoginActivity : AppCompatActivity() {
    private lateinit var botRegistrarse: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        botRegistrarse = findViewById(R.id.btnRegister)
        botRegistrarse.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
            this.finish()
        }
    }


    override fun onDestroy() {
        super.onDestroy()

        startActivity(Intent(this, MainActivity::class.java))
    }

}