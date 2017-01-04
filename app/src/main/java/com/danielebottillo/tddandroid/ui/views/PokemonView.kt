package com.danielebottillo.tddandroid.ui.views

import com.danielebottillo.tddandroid.model.Pokemon

interface PokemonView{

    fun showLoading()

    fun hideLoading()

    fun pokemonLoaded(pokemons: List<Pokemon>)
}
