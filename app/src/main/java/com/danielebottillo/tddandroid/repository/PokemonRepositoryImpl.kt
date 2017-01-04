package com.danielebottillo.tddandroid.repository

import com.danielebottillo.tddandroid.model.Pokemon
import com.danielebottillo.tddandroid.network.PokemonService

class PokemonRepositoryImpl(val client: PokemonService) : PokemonRepository {

    override fun getPokemon(): List<Pokemon> {
        val response = client.listPokemon().execute()
        return response.body().results.map { Pokemon(it.name) }
    }
}