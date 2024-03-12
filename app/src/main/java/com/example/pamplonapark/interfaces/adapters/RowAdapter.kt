package com.example.pamplonapark.interfaces.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pamplonapark.R
import com.example.pamplonapark.interfaces.adapters.items.ParkingItem

/**
 * Adaptador para el RecyclerView en la [RowActivity].
 * @param context Contexto de la aplicación.
 * @param dataList Lista de objetos [RowItem] que se mostrarán.
 */
class RowAdapter(private val context: Context, private val dataList: List<ParkingItem>) :
    RecyclerView.Adapter<RowAdapter.RowViewHolder>() {

    /**
     * Crea una nueva instancia de [RowViewHolder].
     * @param parent Grupo de vista principal.
     * @param viewType Tipo de vista.
     * @return La instancia de [RowViewHolder] creada.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rowitem, parent, false)
        return RowViewHolder(view)
    }
    /**
     * Vincula los datos al [RowViewHolder].
     * @param holder [RowViewHolder] al que se vinculan los datos.
     * @param position Posición del elemento en la lista de datos.
     */
    override fun onBindViewHolder(holder: RowViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.bind(currentItem)
    }
    /**
     * Obtiene el número total de elementos en la lista de datos.
     * @return El número total de elementos.
     */

    override fun getItemCount(): Int {
        return dataList.size
    }

    /**
     * ViewHolder para una sola fila en el RecyclerView.
     * @param itemView Vista para una sola fila.
     */

    inner class RowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.direccion)
        private val subtitleTextView: TextView = itemView.findViewById(R.id.precio)
        private val extraTextView: TextView = itemView.findViewById(R.id.horario)
        private val button : ImageButton = itemView.findViewById(R.id.favoritos);

        /**
         * Vincula datos al [RowViewHolder].
         * @param rowItem Objeto [RowItem] para vincular.
         */
        fun bind(rowItem: ParkingItem) {
            titleTextView.text = rowItem.title
            subtitleTextView.text = "Horario (24h): " + rowItem.subtitle
            extraTextView.text = "Plazas libres: " + rowItem.extraText

            button.setOnClickListener{

                // Compara con el drawable deseado (baseline_favorite_24)
                if (rowItem.status == "fill"){
                    button.setImageResource(R.drawable.baseline_favorite_border_24)
                    rowItem.status = "clear"
                    //removeFav()
                } else {
                    // Si el drawable actual no es baseline_favorite_24, cambia a baseline_favorite_24
                    button.setImageResource(R.drawable.baseline_favorite_24)
                    rowItem.status = "fill"
                    //setFav();
                }

            }
        }

    }
}
