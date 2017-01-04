package com.danielebottillo.tddandroid.dagger

import android.content.Context
import com.birbit.android.jobqueue.JobManager
import com.birbit.android.jobqueue.config.Configuration
import com.danielebottillo.tddandroid.interactors.JobLogger
import com.danielebottillo.tddandroid.interactors.PokemonInteractor
import com.danielebottillo.tddandroid.interactors.PokemonInteractorImpl
import com.danielebottillo.tddandroid.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import org.greenrobot.eventbus.EventBus
import javax.inject.Singleton

@Module
class InteractorModule {

    @Provides
    @Singleton
    fun providesJobManager(context: Context): JobManager {
        val builder = Configuration.Builder(context)
                .customLogger(JobLogger())
                .minConsumerCount(1)
                .maxConsumerCount(3)
                .loadFactor(3)
                .consumerKeepAlive(120)
        return JobManager(builder.build())
    }

    @Provides
    fun providesPokemonInteractor(bus: EventBus, jobManager: JobManager, repository: PokemonRepository): PokemonInteractor {
        return PokemonInteractorImpl(jobManager, repository, bus)
    }
}