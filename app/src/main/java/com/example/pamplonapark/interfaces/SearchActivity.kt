package com.example.pamplonapark.interfaces
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pamplonapark.R

class SearchActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var rowAdapter: RowAdapter

    var isImageChanged = false
    private lateinit var btnFavoritos : ImageButton

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
