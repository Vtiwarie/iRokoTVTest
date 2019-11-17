package com.example.irokutest.ui.main

import android.util.Log
import com.example.irokutest.repository.MovieRepository
import com.example.irokutest.ui.base.BasePresenter
import javax.inject.Inject

/**
 * @author Vishaan Tiwarie
 *
 * MainFragment Presenter
 */
class MainPresenter @Inject constructor(private val movieRepository: MovieRepository) :
    BasePresenter<MainView>() {

    /**
     * 1. Make network call to fetch latest movie data
     * 2. Save movie data to database (caching)
     * 3. Reload UI with latest data from database
     */
    override fun start() {
        disposables += movieRepository.fetchPopularMovies()
            .subscribe({
                //save to database in IO thread
                Log.d("", it.toString())
            }, { error ->
                Log.d("", error.message)
            }
            )
        disposables += movieRepository.fetchTopMovies()
            .subscribe({
                //save to database in IO thread
                Log.d("", it.toString())
            }, { error ->
                Log.d("", error.message)
            }
            )
    }
}