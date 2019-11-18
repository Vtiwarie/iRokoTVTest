package com.example.irokutest.ui.detail

import com.example.irokutest.repository.MovieRepository
import com.example.irokutest.ui.base.BasePresenter
import javax.inject.Inject

/**
 * @author Vishaan Tiwarie
 *
 * Movie Detail Presenter
 */
class DetailPresenter @Inject constructor(private val movieRepository: MovieRepository) :
    BasePresenter<DetailView>() {

    var movieId: Int = -1

    override fun start() {
        val movie = movieRepository.getMovie(movieId) ?: return
        view?.showMovieDetails(movie)
    }

    companion object {
        const val TAG = "DetailPresenter"
    }
}