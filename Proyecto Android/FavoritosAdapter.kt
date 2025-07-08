package com.example.proyectofinal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FavoritosAdapter(private val nombresPlantas: List<String>, private val idsImagenes: List<Int>) : RecyclerView.Adapter<FavoritosAdapter.PlantaFavoritaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantaFavoritaViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_planta_favorita, parent, false)
        return PlantaFavoritaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PlantaFavoritaViewHolder, position: Int) {
        val nombrePlanta = nombresPlantas[position]
        val imagenResId = idsImagenes[position]
        holder.bind(nombrePlanta, imagenResId)
    }

    override fun getItemCount(): Int {
        return nombresPlantas.size
    }

    inner class PlantaFavoritaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageViewPlanta: ImageView = itemView.findViewById(R.id.imageViewPlantaFavorita)
        private val textViewNombrePlanta: TextView = itemView.findViewById(R.id.textViewNombrePlantaFavorita)

        fun bind(nombrePlanta: String, imagenResId: Int) {
            imageViewPlanta.setImageResource(imagenResId)
            textViewNombrePlanta.text = nombrePlanta
        }
    }
}
