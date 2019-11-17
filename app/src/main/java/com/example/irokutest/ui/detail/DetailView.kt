package com.example.irokutest.ui.detail

import com.example.irokutest.model.Movie
import com.example.irokutest.ui.base.BaseView

interface DetailView : BaseView {
    fun showMovieDetails(movie: Movie)
}