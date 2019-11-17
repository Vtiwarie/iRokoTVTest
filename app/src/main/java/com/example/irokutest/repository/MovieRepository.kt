package com.example.irokutest.repository

import com.example.irokutest.api.NetworkService
import javax.inject.Inject


class MovieRepository @Inject constructor(private val networkService: NetworkService) :
    BaseRepository() {

    /**
     * The the network service to fetch popular movies from the API
     */
    fun fetchPopularMovies() = networkService.fetchPopularMovies()

    /**
     * The the network service to fetch top rated movies from the API
     */
    fun fetchTopMovies() = networkService.fetchTopMovies()

}
