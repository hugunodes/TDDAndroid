package com.danielebottillo.tddandroid.interactors

import com.birbit.android.jobqueue.Job
import com.birbit.android.jobqueue.Params
import com.birbit.android.jobqueue.RetryConstraint
import com.danielebottillo.tddandroid.model.Pokemon
import com.danielebottillo.tddandroid.repository.PokemonRepository
import org.greenrobot.eventbus.EventBus

class GetPokemonJob(val params: Params?, val repository: PokemonRepository, val bus: EventBus) : Job(params) {

    override fun shouldReRunOnThrowable(throwable: Throwable, runCount: Int, maxRunCount: Int): RetryConstraint {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onAdded() {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCancel(cancelReason: Int, throwable: Throwable?) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRun() {
        bus.postSticky(FinishedEvent(true, repository.getPokemon()))
    }

    class FinishedEvent(var success:Boolean, var pokemons:List<Pokemon>)

}