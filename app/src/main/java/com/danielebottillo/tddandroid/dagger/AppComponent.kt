package com.danielebottillo.tddandroid.dagger

import dagger.Component
import org.greenrobot.eventbus.EventBus
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, NetworkModule::class,
        RepositoryModule::class, InteractorModule::class))
interface AppComponent {

    fun providesEventBus(): EventBus

    fun providesPokemonInteractor(): PokemonInteractor
}
        