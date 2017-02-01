package com.danielebottillo.tddandroid.network

import com.danielebottillo.tddandroid.network.response.ListPokemonResponse

class PokemonRestClientImpl(val service:PokemonService) : PokemonRestClient {

    override fun listPokemon() : ListPokemonResponse {
        return service.listPokemon().execute().body()
    }

}