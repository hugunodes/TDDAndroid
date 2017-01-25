package com.danielebottillo.tddandroid.repository

import com.danielebottillo.tddandroid.model.Pokemon

interface PokemonRepository {
    fun getPokemon(): List<Pokemon>
}