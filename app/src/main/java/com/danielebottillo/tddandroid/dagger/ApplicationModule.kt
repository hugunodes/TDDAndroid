package com.danielebottillo.tddandroid.dagger

import android.content.Context
import com.danielebottillo.tddandroid.PokemonApp
import dagger.Module
import dagger.Provides
import org.greenrobot.eventbus.EventBus
import javax.inject.Singleton

@Module
class ApplicationModule(val app: PokemonApp){

    @Provides
    @Singleton
    internal fun provideContext(): Context {
        return app.applicationContext
    }

    @Provides
    @Singleton
    fun provideBus(): EventBus{
        return EventBus.getDefault()
    }
}