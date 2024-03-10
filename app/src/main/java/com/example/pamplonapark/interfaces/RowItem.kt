package com.example.pamplonapark.interfaces

import android.inputmethodservice.Keyboard.Row
import android.view.View
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import com.example.pamplonapark.R

/**
 * Clase de datos que representa un elemento de fila en el RecyclerView.
 * @param title Título del elemento de fila.
 * @param subtitle Subtítulo del elemento de fila.
 * @param extraText Texto adicional del elemento de fila.
 * @param status Estado del elemento de fila (p. ej., "fill" o "clear").
 */

data class RowItem(
    val title: String,
    val subtitle: String,
    val extraText: String,
    var status: String
) {


    /**
     * Sobrescribe la función equals para comparar dos objetos [RowItem] basándose en su estado.
     * @param other Otro objeto a comparar.
     * @return `true` si los estados son iguales, de lo contrario, `false`.
     */
    override fun equals(other: Any?): Boolean {
        val other_parsed = other as RowItem;
        return this.status == other_parsed.status;
    }
}



