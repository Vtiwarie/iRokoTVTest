package com.example.irokutest.api

import android.util.Log
import com.example.irokutest.App
import com.example.irokutest.R
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NetworkService @Inject constructor(
    var api: NetworkApi
) {

    private val apiKey = App.instance.resources.getString(R.string.api_key)

    fun fetchPopularMovies() = api.fetchPopularMovies(apiKey)
        .subscribeOn(Schedulers.newThread())
        .observeOn(Schedulers.io())
        .subscribe({
            //save to database in IO thread
            Log.d("", it.toString())
        }, { error ->
            Log.d("", error.message)
        }
        )

    fun fetchTopMovies() = api.fetchTopMovies(apiKey)
        .subscribeOn(Schedulers.newThread())
        .observeOn(Schedulers.io())
        .subscribe({
            //save to database in IO thread
            Log.d("", it.toString())
        }, { error ->
            Log.d("", error.message)
        }
        )
}
