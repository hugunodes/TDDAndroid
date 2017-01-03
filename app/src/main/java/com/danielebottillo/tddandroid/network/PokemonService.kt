package com.danielebottillo.tddandroid.network

import com.danielebottillo.tddandroid.network.response.ListPokemonResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    @GET("/pokemon")
    fun listPokemon(@Path("offset") offset: String = "0"): Call<ListPokemonResponse>
}