package com.example.irokutest.ui.player

import com.example.irokutest.repository.MovieRepository
import com.example.irokutest.ui.base.BasePresenter
import javax.inject.Inject

/**
 * @author Vishaan Tiwarie
 *
 * PlayerFragment Presenter
 */
class PlayerPresenter @Inject constructor(private val movieRepository: MovieRepository) :
    BasePresenter<PlayerView>() {

    override fun start() {
    }

    companion object {
        const val TAG = "PlayerPresenter"
    }
}