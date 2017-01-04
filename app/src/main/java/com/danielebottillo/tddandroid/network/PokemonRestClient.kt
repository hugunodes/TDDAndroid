package com.danielebottillo.tddandroid.network

import com.danielebottillo.tddandroid.network.response.ListPokemonResponse
import retrofit2.Call

class PokemonRestClient(val pokemonApi: PokemonService) {

    fun listPokemon(offset: String): Call<ListPokemonResponse> {
        return pokemonApi.listPokemon(offset)
    }

}