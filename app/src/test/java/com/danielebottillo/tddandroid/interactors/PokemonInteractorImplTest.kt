package com.danielebottillo.tddandroid.interactors

import com.birbit.android.jobqueue.JobManager
import com.danielebottillo.tddandroid.repository.PokemonRepository
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.greenrobot.eventbus.EventBus
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.junit.MockitoJUnit

class PokemonInteractorImplTest {

    @Rule @JvmField var mockitoRule = MockitoJUnit.rule()

    lateinit var underTest: PokemonInteractor

    @Mock
    lateinit var jobManager: JobManager

    @Mock
    lateinit var repository: PokemonRepository

    @Mock
    lateinit var bus: EventBus

    var jobCaptor: ArgumentCaptor<GetPokemonJob> = ArgumentCaptor.forClass(GetPokemonJob::class.java)

    @Before
    fun setUp() {
        underTest = PokemonInteractorImpl(jobManager, repository, bus)
    }

    @Test
    fun onRequestPokemon_shouldLaunchGetPokemonJob() {
        underTest.requestPokemon()

        verify(jobManager).addJobInBackground(jobCaptor.capture())
        assertTrue(jobCaptor.value is GetPokemonJob)
        assertEquals(1, jobCaptor.value.params?.priority)
        assertTrue(jobCaptor.value.params?.isNetworkRequired!!)
        verifyNoMoreInteractions(jobManager)

    }
}