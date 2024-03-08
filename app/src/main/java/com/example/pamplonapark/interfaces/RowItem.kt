package com.example.pamplonapark.interfaces

import android.inputmethodservice.Keyboard.Row
import android.view.View
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import com.example.pamplonapark.R

data class RowItem(
    val title: String,
    val subtitle: String,
    val extraText: String,
    var status: String
) {
    /* fun onFavoritosButtonClick(view: View) {
        imageButton = findViewById(R.id.favoritos)

        // Obten el drawable actual del ImageButton
        val currentDrawable = imageButton.drawable

        // Compara con el drawable deseado (baseline_favorite_24)
        if (currentDrawable.constantState == ContextCompat.getDrawable(this, R.drawable.baseline_favorite_24)?.constantState) {
            // Si el drawable actual es baseline_favorite_24, cambia a baseline_favorite_border_24
            imageButton.setImageResource(R.drawable.baseline_favorite_border_24)
        } else {
            // Si el drawable actual no es baseline_favorite_24, cambia a baseline_favorite_24
            imageButton.setImageResource(R.drawable.baseline_favorite_24)
        }
    }*/
    override fun equals(other: Any?): Boolean {
        val other_parsed = other as RowItem;
        return this.status == other_parsed.status;
    }
}



