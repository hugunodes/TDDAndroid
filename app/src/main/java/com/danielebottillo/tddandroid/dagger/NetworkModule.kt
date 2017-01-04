package com.danielebottillo.tddandroid.dagger

import com.danielebottillo.tddandroid.network.PokemonService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesRestClient(client: OkHttpClient): PokemonService {
        val retrofit = Retrofit.Builder()
                .client(client)
                .baseUrl("http://pokeapi.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit.create(PokemonService::class.java)
    }

    @Provides
    @Singleton
    internal fun providesOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
    }
}