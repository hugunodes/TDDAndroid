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

    lateinit var underTest: PokemonRestClient

    @Mock
    lateinit var service: PokemonService

    @Mock
    lateinit var call: Call<ListPokemonResponse>

    @Mock
    lateinit var response: Response<ListPokemonResponse>

    @Mock
    lateinit var pokemons: ListPokemonResponse

    @Before
    fun setUp() {
        Mockito.`when`(service.listPokemon()).thenReturn(call)
        Mockito.`when`(call.execute()).thenReturn(response)
        Mockito.`when`(response.body()).thenReturn(pokemons)
        underTest = PokemonRestClientImpl(service)
    }

    @Test
    fun `shouldCallRetrofitClient_andReturnResponse`() {
        val result = underTest.listPokemon()

        verify(service).listPokemon()
        assertEquals(pokemons, result)
        verifyNoMoreInteractions(service)
    }
}