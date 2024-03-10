package com.example.pamplonapark.interfaces

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.pamplonapark.R
import com.example.pamplonapark.database.DatabaseManager

class MenuActivity : AppCompatActivity() {
    private lateinit var btnLista: Button
    private lateinit var btnFavoritos: Button
    private lateinit var btnSalir: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        btnLista = findViewById(R.id.btn_lista_parking)
        btnFavoritos = findViewById(R.id.btn_favoritos)
        btnSalir = findViewById(R.id.btn_salir)


        btnSalir.setOnClickListener {
            this.finish()
        }

        btnLista.setOnClickListener{
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }


    }

}