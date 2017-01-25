package com.danielebottillo.tddandroid.repository

import com.danielebottillo.tddandroid.model.Pokemon
import com.danielebottillo.tddandroid.network.PokemonRestClient

class PokemonRepositoryImpl(val client: PokemonRestClient) : PokemonRepository {

    override fun getPokemon(): List<Pokemon> {
        return client.listPokemon().results.map { Pokemon(it.name) }
    }
}