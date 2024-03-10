package com.example.pamplonapark.interfaces
<<<<<<< HEAD

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.pamplonapark.R
import com.example.pamplonapark.internal_code.HttpRequests
import com.example.pamplonapark.internal_code.ServerManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        Log.d("test", "Activity created")
        /*val recycler: RecyclerView = findViewById(R.id.recicler)
        recycler.adapter = ParkingAdapter(ServerManager.importDataFromNeo4j())*/
        ServerManager.getAllParkings()
    }
}
=======
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pamplonapark.R

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

        val dataList = generateDummyData() // Implement this function to generate your data

        recyclerView = findViewById(R.id.recycler)
        rowAdapter = RowAdapter(this, dataList)


        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = rowAdapter

    }

    /**
     * Genera datos de ejemplo para la lista.
     * @return Lista de objetos [RowItem].
     */
    private fun generateDummyData(): List<RowItem> {
        // Implement this function to generate your data
        // Return a list of RowItem objects

        val rows = mutableListOf<RowItem>()

        // Agrega elementos a la lista según tus necesidades
        rows.add(RowItem("Dirección 1", "Precio 1", "Horario 1", "clear"))
        rows.add(RowItem("Dirección 2", "Precio 2", "Horario 2", "clear"))
        rows.add(RowItem("Dirección 3", "Precio 3", "Horario 3", "clear"))

        return rows
    }


}
>>>>>>> e3740b37ee9698d4bb3c2b03d0356eab5795dc51
