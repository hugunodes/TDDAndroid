package com.danielebottillo.tddandroid.network

import com.danielebottillo.tddandroid.network.response.ListPokemonResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonService {

    @GET("api/v2/pokemon")
    fun listPokemon(@Query("offset") offset: String = "0"): Call<ListPokemonResponse>

}