package com.example.irokutest.ui.list.adapter

import android.view.ViewGroup
import com.example.irokutest.R
import com.example.irokutest.ui.base.BaseViewHolder
import com.example.irokutest.util.inflateView
import kotlinx.android.synthetic.main.item_movie_header.*

class MovieHeaderViewHolder(parent: ViewGroup) :
    BaseViewHolder(inflateView(R.layout.item_movie_header, parent, false)) {

    fun bind(viewtype: MovieListAdapter.VIEWTYPE) {
        header.text = when (viewtype) {
            MovieListAdapter.VIEWTYPE.HEADER_TOP_MOVIES -> {
                itemView.context.getString(R.string.top_movies)
            }
            else -> {
                itemView.context.getString(R.string.popular_movies)
            }
        }
    }

}