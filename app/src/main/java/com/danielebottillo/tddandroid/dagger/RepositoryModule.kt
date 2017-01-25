package com.danielebottillo.tddandroid.dagger

import com.danielebottillo.tddandroid.network.PokemonRestClient
import com.danielebottillo.tddandroid.repository.PokemonRepository
import com.danielebottillo.tddandroid.repository.PokemonRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun providesPokemonRepository(client: PokemonRestClient): PokemonRepository {
        return PokemonRepositoryImpl(client)
    }
}