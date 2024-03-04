package com.example.pamplonapark.interfaces.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pamplonapark.R
import com.example.pamplonapark.interfaces.adapters.items.ParkingItem

class ParkingAdapter(private val items: List<ParkingItem>) : RecyclerView.Adapter<ParkingAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val row: View = LayoutInflater.from(parent.context).inflate(R.layout.row_reciclerview, parent, false)
        return ViewHolder(row)
    }
    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val color = items[position]
        holder.bindRow(color)
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)

        fun bindRow(item: ParkingItem) {
            titleTextView.text = item.name
        }
    }
}