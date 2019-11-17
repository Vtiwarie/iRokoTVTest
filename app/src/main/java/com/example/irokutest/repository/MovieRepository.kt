package com.example.irokutest.repository

import com.example.irokutest.App
import com.example.irokutest.R
import com.example.irokutest.api.NetworkApi
import com.example.irokutest.model.Movie
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import io.realm.RealmResults
import javax.inject.Inject


class MovieRepository @Inject constructor(
    var api: NetworkApi
) :
    BaseRepository() {

    private val apiKey = App.instance.resources.getString(R.string.api_key)

    fun fetchPopularMovies() = api.fetchPopularMovies(apiKey)
        .subscribeOn(Schedulers.newThread())
        .observeOn(Schedulers.io())


    fun fetchTopMovies() = api.fetchTopMovies(apiKey)
        .subscribeOn(Schedulers.newThread())
        .observeOn(Schedulers.io())

    fun saveMovies(movies: List<Movie>) {
        getRealm().executeTransactionAsync {
            it.insertOrUpdate(movies)
        }
    }

    fun getPopularMovies(): Flowable<RealmResults<Movie>> {
        return getRealm().where(Movie::class.java)
            .findAllAsync()
            .asFlowable()
    }

    fun getTopMovies(): Flowable<RealmResults<Movie>> {
        return getRealm().where(Movie::class.java)
            .findAllAsync()
            .asFlowable()
    }
}
