package com.danielebottillo.tddandroid.interactors

import com.birbit.android.jobqueue.Job
import com.birbit.android.jobqueue.Params
import com.birbit.android.jobqueue.RetryConstraint
import com.danielebottillo.tddandroid.model.Pokemon
import com.danielebottillo.tddandroid.repository.PokemonRepository
import org.greenrobot.eventbus.EventBus

class GetPokemonJob(val params: Params?, val repository: PokemonRepository, val bus: EventBus) : Job(params) {

    override fun shouldReRunOnThrowable(throwable: Throwable, runCount: Int, maxRunCount: Int): RetryConstraint {
        return RetryConstraint(false)
    }

    override fun onAdded() {
    }

    override fun onCancel(cancelReason: Int, throwable: Throwable?) {
    }

    override fun onRun() {
        val pokemon = repository.getPokemon()
        bus.postSticky(FinishedEvent(true, pokemon))
    }

    open class FinishedEvent(val success: Boolean, open val pokemon: List<Pokemon>)

}