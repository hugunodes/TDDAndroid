package com.danielebottillo.tddandroid.dagger

import com.danielebottillo.tddandroid.interactors.PokemonInteractor
import com.danielebottillo.tddandroid.ui.presenters.PokemonPresenter
import com.danielebottillo.tddandroid.ui.presenters.PokemonPresenterImpl
import dagger.Module
import dagger.Provides
import org.greenrobot.eventbus.EventBus

@Module
class PresenterModule{

    @Provides
    fun providesPokemonPresenter(bus: EventBus, interactor: PokemonInteractor) : PokemonPresenter{
        return PokemonPresenterImpl(interactor, bus)
    }
}