package com.example.pamplonapark.interfaces

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.pamplonapark.R

class FavoritoActivity : AppCompatActivity() {

    private lateinit var editTextBuscar: EditText

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favoritos) // Reemplaza "activity_favorito" con el nombre correcto de tu layout

        editTextBuscar = findViewById(R.id.editTextBuscar) // Reemplaza "editTextBuscar" con el ID correcto de tu EditText

        // Agregar el TextWatcher para manejar el EditText
        editTextBuscar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Ocultar el ícono de búsqueda y mostrar el ícono de cancelar
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

        // Agregar el OnClickListener para el ícono de cancelar
        editTextBuscar.setOnTouchListener { v, event ->
            val DRAWABLE_RIGHT = 2
            if (event.action == MotionEvent.ACTION_UP) {
                val drawableRight = (v as EditText).compoundDrawables[DRAWABLE_RIGHT]
                if (drawableRight != null && event.rawX >= v.right - drawableRight.bounds.width()) {
                    // Borrar el texto cuando se hace clic en el ícono de cancelar
                    editTextBuscar.text.clear()
                    return@setOnTouchListener true
                }
            }
            return@setOnTouchListener false
        }
    }
}
