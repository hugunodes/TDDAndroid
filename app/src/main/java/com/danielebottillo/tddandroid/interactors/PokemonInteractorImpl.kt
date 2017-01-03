package com.danielebottillo.tddandroid.interactors

import com.birbit.android.jobqueue.JobManager
import com.birbit.android.jobqueue.Params
import com.danielebottillo.tddandroid.repository.PokemonRepository
import org.greenrobot.eventbus.EventBus

class PokemonInteractorImpl(val jobManager: JobManager,
                            val repository: PokemonRepository,
                            val bus: EventBus) : PokemonInteractor {

    override fun requestPokemon() {
        val params = Params(1).requireNetwork()
        jobManager.addJob(GetPokemonJob(params, repository, bus))
    }
}