package com.danielebottillo.tddandroid.dagger

import com.danielebottillo.tddandroid.ui.pokemonlist.PokemonListActivity
import dagger.Component

@UIScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(PresenterModule::class))
interface UIComponent {

    fun inject(activity: PokemonListActivity)

}
