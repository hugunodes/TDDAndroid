package com.danielebottillo.tddandroid.network

import com.danielebottillo.tddandroid.network.response.ListPokemonResponse

interface PokemonRestClient {
    fun listPokemon(offset: String = "0"): ListPokemonResponse
}