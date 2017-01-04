package com.danielebottillo.tddandroid.ui.presenters

import com.danielebottillo.tddandroid.interactors.GetPokemonJob
import com.danielebottillo.tddandroid.interactors.PokemonInteractor
import com.danielebottillo.tddandroid.ui.views.PokemonView
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class PokemonPresenterImpl(val interactor: PokemonInteractor, val bus: EventBus) : PokemonPresenter {

    lateinit var view: PokemonView

    override fun init(view: PokemonView) {
        this.view = view
    }

    override fun onStart() {
        bus.register(this)
        interactor.requestPokemon()
        view.showLoading()
    }

    override fun onStop() {
        bus.unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    override fun onPokemonRetrieved(event: GetPokemonJob.FinishedEvent) {
        bus.removeStickyEvent(event)
        view.hideLoading()
        view.pokemonLoaded(event.pokemon)
    }
}
