package com.example.irokutest.ui.main

import com.example.irokutest.repository.MovieRepository
import com.example.irokutest.ui.base.BasePresenter
import javax.inject.Inject

/**
 * @author Vishaan Tiwarie
 *
 * MainFragment Presenter
 */
class MainPresenter @Inject constructor(private val movieRepository: MovieRepository) : BasePresenter<MainView>() {

    /**
     * Make network call to
     */
    override fun start() {
        movieRepository.fetchMovies()
    }
}