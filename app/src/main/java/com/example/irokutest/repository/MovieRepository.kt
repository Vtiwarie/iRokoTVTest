package com.example.irokutest.repository

import com.example.irokutest.App
import com.example.irokutest.R
import com.example.irokutest.api.NetworkApi
import io.reactivex.schedulers.Schedulers
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
}
