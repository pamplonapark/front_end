package com.example.pamplonapark.interfaces

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pamplonapark.MainActivity
import com.example.pamplonapark.R
import com.example.pamplonapark.interfaces.adapters.RowAdapter
import com.example.pamplonapark.interfaces.adapters.items.ParkingItem
import com.example.pamplonapark.internal_code.ServerManager
import com.example.pamplonapark.internal_code.ServerManager.Companion.getAllParkings
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Actividad que muestra una lista de elementos usando un RecyclerView.
 */
class SearchActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var rowAdapter: RowAdapter

    private lateinit var btnFavoritos: ImageButton
    private lateinit var btnReturn: ImageButton

    /**
     * Método llamado cuando se crea la actividad.
     * @param savedInstanceState Datos de estado previamente guardados.
     */
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        // Llama a la función generateData dentro de una corrutina y espera a que finalice
        GlobalScope.launch(Dispatchers.Main) {
            val dataList = generateData()
            setupRecyclerView(dataList)
        }
        btnFavoritos = findViewById(R.id.favs)
        btnFavoritos.setOnClickListener {
            val intent = Intent(this, FavoritoActivity::class.java);
            intent.putExtra("username", intent.getStringExtra("username"))

            startActivity(intent)
            this.finish()
        }

        btnReturn = findViewById(R.id.volver)
        btnReturn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            this.finish()
        }
    }

    private fun setupRecyclerView(dataList: List<ParkingItem>) {
        recyclerView = findViewById(R.id.recycler)
        rowAdapter = RowAdapter(this, dataList)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = rowAdapter
    }

    private suspend fun generateData(): List<ParkingItem> {
        return getAllParkings(intent.getStringExtra("username"))
    }
}
