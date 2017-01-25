package com.danielebottillo.tddandroid.ui.presenters

import com.danielebottillo.tddandroid.interactors.GetPokemonJob
import com.danielebottillo.tddandroid.interactors.PokemonInteractor
import com.danielebottillo.tddandroid.model.Pokemon
import com.danielebottillo.tddandroid.ui.views.PokemonView
import org.greenrobot.eventbus.EventBus
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.junit.MockitoJUnit

class PokemonPresenterImplTest {

    @Rule @JvmField var mockitoRule = MockitoJUnit.rule()

    lateinit var underTest: PokemonPresenter

    @Mock
    lateinit var view: PokemonView

    @Mock
    lateinit var event: GetPokemonJob.FinishedEvent

    @Mock
    lateinit var interactor: PokemonInteractor

    @Mock
    lateinit var bus: EventBus

    var list = arrayListOf(Pokemon("Squirtle"), Pokemon("Bulbasaur"))

    @Before
    fun setUp() {
        Mockito.`when`(event.pokemon).thenReturn(list)
        underTest = PokemonPresenterImpl(interactor, bus)
        underTest.init(view)
    }

    @Test
    fun `shouldRequestPokemon`() {
        underTest.onStart()

        verify(interactor).requestPokemon()
        verify(view).showLoading()
        verifyNoMoreInteractions(interactor, view)
    }

    @Test
    fun `shouldShowPokemon_andRemoveEventFromBus`() {
        underTest.onPokemonRetrieved(event)

        verify(view).hideLoading()
        verify(view).pokemonLoaded(event.pokemon)
        verify(bus).removeStickyEvent(event)
        verifyNoMoreInteractions(bus, view)
    }
}