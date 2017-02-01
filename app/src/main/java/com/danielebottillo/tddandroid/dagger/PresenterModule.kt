package com.danielebottillo.tddandroid.dagger

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