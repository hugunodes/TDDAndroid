package com.danielebottillo.tddandroid.ui.pokemonlist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.danielebottillo.tddandroid.R
import com.danielebottillo.tddandroid.model.Pokemon

class PokemonAdapter(val pokemon: List<Pokemon>) : RecyclerView.Adapter<PokemonViewHolder>() {

    override fun onBindViewHolder(holder: PokemonViewHolder?, position: Int) {
        holder?.nameText?.text = pokemon[position].name

        val context = holder?.itemView?.context!!
        val res = context.resources?.getIdentifier("pokemon_" + (position + 1).toString(), "drawable", context.packageName)
        holder?.image?.setImageResource(res!!)
    }

    override fun getItemCount(): Int {
        return pokemon.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.pokemon_item, parent, false))
    }

}