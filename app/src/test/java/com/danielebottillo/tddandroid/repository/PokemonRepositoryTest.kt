package com.danielebottillo.tddandroid.repository

import com.danielebottillo.tddandroid.network.PokemonService
import com.danielebottillo.tddandroid.network.response.ListPokemonResponse
import com.danielebottillo.tddandroid.network.response.PokemonResponse
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
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

class PokemonRepositoryTest {

    val SQUIRTLE = "Squirtle"
    val CHARMENDER = "Squirtle"
    val NUMBER_OF_POKEMONS = 2

    @Rule @JvmField var mockitoRule = MockitoJUnit.rule()

    lateinit var underTest: PokemonRepository

    @Mock
    lateinit var client: PokemonService

    @Mock
    lateinit var response: Call<ListPokemonResponse>

    @Before
    fun setUp() {
        underTest = PokemonRepositoryImpl(client)
    }

    @Test
    fun getPokemon_shouldReturnPokemonsFromNetwork() {
        val squirtle = PokemonResponse(name = SQUIRTLE)
        val charmender = PokemonResponse(name = CHARMENDER)
        val pokemonsResponse = ListPokemonResponse(NUMBER_OF_POKEMONS, listOf(squirtle, charmender))
        Mockito.`when`(client.listPokemon()).thenReturn(response)
        Mockito.`when`(response.execute()).thenReturn(Response.success(pokemonsResponse))

        val result = underTest.getPokemon()

        assertNotNull(result)
        assertEquals(NUMBER_OF_POKEMONS, result.size)
        assertEquals(SQUIRTLE, result[0].name)
        assertEquals(CHARMENDER, result[1].name)
        verify(client).listPokemon()
        verifyNoMoreInteractions(client)
    }
}