package com.danielebottillo.tddandroid.ui.presenters

import com.danielebottillo.tddandroid.interactors.GetPokemonJob
import com.danielebottillo.tddandroid.ui.views.PokemonView

interface PokemonPresenter {

    fun init(view: PokemonView)

    fun onStart()

    fun onStop()

    fun onPokemonRetrieved(event: GetPokemonJob.FinishedEvent)
}