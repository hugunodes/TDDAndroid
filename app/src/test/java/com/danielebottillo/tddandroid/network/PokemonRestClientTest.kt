package com.danielebottillo.tddandroid.network

import com.danielebottillo.tddandroid.network.response.ListPokemonResponse
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.junit.MockitoJUnit
import retrofit2.Call
import retrofit2.Response

class PokemonRestClientTest {

    @Rule @JvmField var mockitoRule = MockitoJUnit.rule()

    lateinit var underTest : PokemonRestClient

    @Mock lateinit var service: PokemonService

    @Mock lateinit var callPokemonResponse : Call<ListPokemonResponse>

    @Mock lateinit var pokemonResponse : Response<ListPokemonResponse>

    @Mock lateinit var pokemonList : ListPokemonResponse

    @Before
    fun setUp() {
        underTest = PokemonRestClientImpl(service)
    }

    @Test
    fun shouldCallListPokemonService_andReturnsPokemonFromApi(){
        Mockito.`when`(service.listPokemon()).thenReturn(callPokemonResponse)
        Mockito.`when`(callPokemonResponse.execute()).thenReturn(pokemonResponse)
        Mockito.`when`(pokemonResponse.body()).thenReturn(pokemonList)

        val result = underTest.listPokemon()

        verify(service).listPokemon()
        assertEquals(pokemonList, result)
        verifyNoMoreInteractions(service)
    }

}