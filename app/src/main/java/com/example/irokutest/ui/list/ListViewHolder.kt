package com.example.irokutest.ui.list

import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.irokutest.R
import com.example.irokutest.model.Movie
import com.example.irokutest.ui.base.BaseViewHolder
import com.example.irokutest.util.inflateView
import kotlinx.android.synthetic.main.item_movie_list.*

class ListViewHolder(parent: ViewGroup) :
    BaseViewHolder(inflateView(R.layout.item_movie_list, parent, false)) {

    fun bind(movie: Movie) {

        val baseUrl = itemView.context.getString(R.string.image_base_url)

        Glide.with(itemView)
            .load("${baseUrl}${movie.poster_path}")
            .into(image)

        title.text = movie.title
    }

}