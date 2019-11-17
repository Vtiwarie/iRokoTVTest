package com.example.irokutest.ui.detail

import com.example.irokutest.repository.MovieRepository
import com.example.irokutest.ui.base.BasePresenter
import javax.inject.Inject

/**
 * @author Vishaan Tiwarie
 *
 * DetailFragment Presenter
 */
class DetailPresenter @Inject constructor(private val movieRepository: MovieRepository) :
    BasePresenter<DetailView>() {

    override fun start() {
    }

    companion object {
        const val TAG = "DetailPresenter"
    }
}