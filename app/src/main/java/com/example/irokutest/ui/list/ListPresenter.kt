package com.example.irokutest.ui.list

import android.util.Log
import com.example.irokutest.repository.MovieRepository
import com.example.irokutest.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * @author Vishaan Tiwarie
 *
 * ListFragment Presenter
 */
class ListPresenter @Inject constructor(private val movieRepository: MovieRepository) :
    BasePresenter<ListView>() {

    /**
     * 1. Make network call to fetch latest movie data
     * 2. Save movie data to database (caching)
     * 3. Reload UI with latest data from database
     */
    override fun start() {
        disposables += movieRepository.getPopularMovies()
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.showPopularMovies()
            }, { error ->
                Log.e(TAG, error.message)
            })

        disposables += movieRepository.getTopMovies()
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.showTopMovies()
            }, { error ->
                Log.e(TAG, error.message)
            })


        disposables += movieRepository.fetchPopularMovies()
            .subscribe({
                //save to database in IO thread
                movieRepository.saveMovies(it.results)
            }, { error ->
                Log.e(TAG, error.message)
            }
            )
        disposables += movieRepository.fetchTopMovies()
            .subscribe({
                //save to database in IO thread
                movieRepository.saveMovies(it.results)
            }, { error ->
                Log.e(TAG, error.message)
            }
            )
    }

    companion object {
        const val TAG = "DetailPresenter"
    }
}