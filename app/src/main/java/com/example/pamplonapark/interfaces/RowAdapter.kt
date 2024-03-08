package com.example.pamplonapark.interfaces

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pamplonapark.R
import kotlin.math.absoluteValue

class RowAdapter(private val context: Context, private val dataList: List<RowItem>) :
    RecyclerView.Adapter<RowAdapter.RowViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rowitem, parent, false)
        return RowViewHolder(view)
    }

    override fun onBindViewHolder(holder: RowViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class RowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.direccion)
        private val subtitleTextView: TextView = itemView.findViewById(R.id.precio)
        private val extraTextView: TextView = itemView.findViewById(R.id.horario)
        private val button : ImageButton = itemView.findViewById(R.id.favoritos);

        fun bind(rowItem: RowItem) {
            titleTextView.text = rowItem.title
            subtitleTextView.text = rowItem.subtitle
            extraTextView.text = rowItem.extraText

            button.setOnClickListener{

                // Compara con el drawable deseado (baseline_favorite_24)
                if (rowItem.status == "fill"){
                    button.setImageResource(R.drawable.baseline_favorite_border_24)
                    rowItem.status = "clear"
                } else {
                    // Si el drawable actual no es baseline_favorite_24, cambia a baseline_favorite_24
                    button.setImageResource(R.drawable.baseline_favorite_24)
                    rowItem.status = "fill"
                }

            }
        }

    }


}
