package com.danielebottillo.tddandroid.ui.pokemonlist

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.danielebottillo.tddandroid.R

class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val nameText: TextView = itemView.findViewById(R.id.pokemon_name) as TextView
    val image: ImageView = itemView.findViewById(R.id.pokemon_image) as ImageView
}