package com.example.pamplonapark.interfaces

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