package com.example.irokutest.repository

import com.example.irokutest.api.NetworkService
import javax.inject.Inject


class MovieRepository @Inject constructor(private val networkService: NetworkService) :
    BaseRepository() {

    /**
     * The the network service to fetch movies from the API
     */
    fun fetchMovies() = networkService.fetchMovies()

}
