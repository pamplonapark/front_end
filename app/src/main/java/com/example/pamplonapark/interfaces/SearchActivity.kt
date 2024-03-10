package com.example.pamplonapark.interfaces

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pamplonapark.MainActivity
import com.example.pamplonapark.R
import com.example.pamplonapark.interfaces.adapters.RowAdapter
import com.example.pamplonapark.interfaces.adapters.items.ParkingItem
import com.example.pamplonapark.internal_code.ServerManager

/**
 * Actividad que muestra una lista de elementos usando un RecyclerView.
 */
class SearchActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var rowAdapter: RowAdapter

    var isImageChanged = false
    private lateinit var btnFavoritos : ImageButton

    /**
     * Método llamado cuando se crea la actividad.
     * @param savedInstanceState Datos de estado previamente guardados.
     */
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val dataList = generateData() // Implement this function to generate your data

        recyclerView = findViewById(R.id.recycler)
        rowAdapter = RowAdapter(this, dataList)


        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = rowAdapter

        /*Button navigation*/
        val btnReturn = findViewById<View>(R.id.volver)
        btnReturn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            this.finish()
        }

        val btnFavoritos = findViewById<View>(R.id.favs)
        btnReturn.setOnClickListener {
            startActivity(Intent(this, FavoritoActivity::class.java))
            this.finish()
        }

    }

    /**
     * Genera datos de ejemplo para la lista.
     * @return Lista de objetos [RowItem].
     */
    private fun generateData(): List<ParkingItem> {
        // Implement this function to generate your data
        // Return a list of RowItem objects

        val rows = ServerManager.getAllParkings();

        return rows
    }


}
