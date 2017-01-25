package com.danielebottillo.tddandroid.network

import com.danielebottillo.tddandroid.network.response.ListPokemonResponse
import retrofit2.Call

class PokemonRestClientImpl(val pokemonService: PokemonService) : PokemonRestClient {
    override fun listPokemon(offset: String): ListPokemonResponse {
        return pokemonService.listPokemon(offset).execute().body()
    }
}