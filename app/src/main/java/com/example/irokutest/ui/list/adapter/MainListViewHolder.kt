package com.example.irokutest.ui.list.adapter

import android.view.ViewGroup
import com.example.irokutest.R
import com.example.irokutest.model.Movie
import com.example.irokutest.ui.base.BaseViewHolder
import com.example.irokutest.util.inflateView
import kotlinx.android.synthetic.main.item_movie_list_main.*

class MainListViewHolder(
    parent: ViewGroup,
    private val adapter: MovieGridAdapter
) : BaseViewHolder(inflateView(R.layout.item_movie_list_main, parent, false)) {

    init {
        grid_recycler.adapter = adapter
    }

    fun bind(movies: List<Movie>, clickListener: ((Movie) -> Unit)? = null) {
        adapter.clickListener = clickListener
        adapter.submitList(movies)
    }

}