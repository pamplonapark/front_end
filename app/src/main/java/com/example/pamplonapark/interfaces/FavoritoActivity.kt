package com.example.pamplonapark.interfaces

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pamplonapark.R
import com.example.pamplonapark.interfaces.adapters.RowAdapter
import com.example.pamplonapark.interfaces.adapters.items.ParkingItem
import com.example.pamplonapark.internal_code.ServerManager
import com.google.android.material.textview.MaterialTextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Activity to manage favorites.
 * Calls the Favorites activity.
 */
class FavoritoActivity : AppCompatActivity() {

    private lateinit var editTextBuscar: EditText
    private lateinit var txt_favoritos : MaterialTextView
    private lateinit var recyclerView : RecyclerView
    private lateinit var rowAdapter: RowAdapter

    /**
     * Method called when the activity is created.
     *
     * @param savedInstanceState Previous instance data if exists.
     */
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favoritos)

        // Llama a la función generateData dentro de una corrutina y espera a que finalice
        GlobalScope.launch(Dispatchers.Main) {
            val dataList = generateData()
            setupRecyclerView(dataList)
        }

        editTextBuscar = findViewById(R.id.editTextBuscar)
        txt_favoritos = findViewById(R.id.txt_favoritos)

        // Add a TextWatcher to handle the EditText
        editTextBuscar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Hide the search icon and show the cancel icon
                if (s?.length ?: 0 > 0) {
                    editTextBuscar.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
                    editTextBuscar.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.asset_cancel, 0)
                } else {
                    editTextBuscar.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
                    editTextBuscar.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_search_24, 0, 0, 0)
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        /**
         * Sets a [View.OnTouchListener] on the [EditText] to detect touch events.
         *
         * @param v The view to which the touch event is applied.
         * @param event The [MotionEvent] object representing the touch event.
         * @return Returns `true` if the touch event was handled, `false` otherwise.
         */
        editTextBuscar.setOnTouchListener { v, event ->
            // Index of the drawable to the right of the EditText
            val DRAWABLE_RIGHT = 2

            // Check if the event is of type ACTION_UP (lifting finger after touching the screen)
            if (event.action == MotionEvent.ACTION_UP) {
                // Get the drawable to the right of the EditText
                val drawableRight = (v as EditText).compoundDrawables[DRAWABLE_RIGHT]
                // Check if the drawable to the right is not null and if the touch event is within the drawable area
                if (drawableRight != null && event.rawX >= v.right - drawableRight.bounds.width()) {
                    // Clear the text of the EditText when the cancel icon is clicked
                    editTextBuscar.text.clear()
                    // Return true to indicate that the touch event was handled
                    return@setOnTouchListener true
                }
            }
            // Return false to indicate that the touch event was not handled
            return@setOnTouchListener false
        }

        txt_favoritos.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java);
            intent.putExtra("username", intent.getStringExtra("username"))

            startActivity(intent)
            this.finish();
        }
    }

    private fun setupRecyclerView(dataList: List<ParkingItem>) {
        recyclerView = findViewById(R.id.recyclerView)
        rowAdapter = RowAdapter(this, dataList)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = rowAdapter
    }

    private suspend fun generateData(): List<ParkingItem> {
        return ServerManager.getFavorites(intent.getStringExtra("username"))
    }
}
