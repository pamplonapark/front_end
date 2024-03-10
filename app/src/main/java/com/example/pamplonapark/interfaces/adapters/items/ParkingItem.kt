package com.example.pamplonapark.interfaces.adapters.items

/**
 * Clase de datos que representa un elemento de fila en el RecyclerView.
 * @param title Título del elemento de fila.
 * @param subtitle Subtítulo del elemento de fila.
 * @param extraText Texto adicional del elemento de fila.
 * @param status Estado del elemento de fila (p. ej., "fill" o "clear").
 */

data class ParkingItem(
    val title: String,
    val subtitle: String,
    val extraText: String,
    var status: String
)




