package com.danielebottillo.tddandroid.interactors

import com.birbit.android.jobqueue.Params
import com.danielebottillo.tddandroid.model.Pokemon
import com.danielebottillo.tddandroid.repository.PokemonRepository
import org.greenrobot.eventbus.EventBus
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.junit.MockitoJUnit

class GetPokemonJobTest {

    @Rule @JvmField var mockitoRule = MockitoJUnit.rule()

    lateinit var underTest: GetPokemonJob

    @Mock
    lateinit var params: Params

    @Mock
    lateinit var bus: EventBus

    @Mock
    lateinit var repository: PokemonRepository

    var finishedEventCaptor: ArgumentCaptor<GetPokemonJob.FinishedEvent> = ArgumentCaptor.forClass(GetPokemonJob.FinishedEvent::class.java)
    var list = arrayListOf(Pokemon("Squirtle"), Pokemon("Bulbasaur"))

    @Before
    fun setUp() {
        Mockito.`when`(repository.getPokemon()).thenReturn(list)
        underTest = GetPokemonJob(params, repository, bus)
    }

    @Test
    fun onRun_shouldCallRepository_andPostEventOnBus() {
        underTest.onRun()

        verify(bus).postSticky(finishedEventCaptor.capture())
        assertTrue(finishedEventCaptor.value.success)
        assertEquals(finishedEventCaptor.value.pokemon, list)

        verify(repository).getPokemon()
        verifyNoMoreInteractions(repository, bus)
    }
}