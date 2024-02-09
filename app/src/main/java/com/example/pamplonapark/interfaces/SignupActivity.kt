package com.example.pamplonapark.interfaces

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.pamplonapark.MainActivity
import com.example.pamplonapark.R
import com.example.pamplonapark.database.DatabaseManager

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
    }
    override fun onDestroy() {
        startActivity(Intent(this, MainActivity::class.java))
        super.onDestroy()


    }
}