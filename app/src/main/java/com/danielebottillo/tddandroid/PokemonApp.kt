package com.danielebottillo.tddandroid

import android.app.Application
import com.danielebottillo.tddandroid.dagger.AppComponent
import com.danielebottillo.tddandroid.dagger.ApplicationModule
import com.danielebottillo.tddandroid.dagger.DaggerAppComponent

class PokemonApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}