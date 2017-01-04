package com.danielebottillo.tddandroid.ui.pokemonlist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import com.danielebottillo.tddandroid.PokemonApp
import com.danielebottillo.tddandroid.R
import com.danielebottillo.tddandroid.dagger.DaggerUIComponent
import com.danielebottillo.tddandroid.model.Pokemon
import com.danielebottillo.tddandroid.ui.presenters.PokemonPresenter
import com.danielebottillo.tddandroid.ui.views.PokemonView
import javax.inject.Inject

class PokemonListActivity : AppCompatActivity(), PokemonView {

    @Inject
    lateinit var presenter: PokemonPresenter

    lateinit var loader: ProgressBar
    lateinit var grid: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loader = findViewById(R.id.loader) as ProgressBar
        grid = findViewById(R.id.grid) as RecyclerView

        grid.setHasFixedSize(true)
        val glm = GridLayoutManager(this, 3)
        grid.addItemDecoration(GridItemDecorator(resources.getDimensionPixelSize(R.dimen.cards_grid_space)))
        grid.layoutManager = glm

        val uiComponent = DaggerUIComponent.builder().appComponent((application as PokemonApp).appComponent).build()
        uiComponent.inject(this)
        presenter.init(this)
    }

    override fun onStart() {
        super.onStart()

        presenter.onStart()
    }

    override fun onStop() {
        super.onStop()

        presenter.onStop()
    }

    override fun showLoading() {
        loader.visibility = View.VISIBLE
        grid.visibility = View.INVISIBLE
    }

    override fun hideLoading() {
        loader.visibility = View.INVISIBLE
        grid.visibility = View.VISIBLE
    }

    override fun pokemonLoaded(pokemons: List<Pokemon>) {
        grid.adapter = PokemonAdapter(pokemons)
    }

}
