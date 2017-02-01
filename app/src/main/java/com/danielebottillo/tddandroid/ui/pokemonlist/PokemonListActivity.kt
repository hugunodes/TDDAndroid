package com.danielebottillo.tddandroid.ui.pokemonlist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.widget.ProgressBar
import com.danielebottillo.tddandroid.R

class PokemonListActivity : AppCompatActivity() {

    lateinit var loader: ProgressBar
    lateinit var grid: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

}
