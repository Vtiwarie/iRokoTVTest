package com.example.irokutest.ui.list

import android.os.Bundle
import com.example.irokutest.App
import com.example.irokutest.R
import com.example.irokutest.model.Movie
import com.example.irokutest.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : BaseFragment<ListPresenter, ListView>(), ListView {

    override val layoutID = R.layout.fragment_list
    private val movieListAdapter: ListAdapter by lazy { ListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.instance.appComponent.inject(this)
    }

    override fun initializeViews() {
        movie_recycler.adapter = movieListAdapter
    }

    override fun showPopularMovies(movies: List<Movie>) {
        movieListAdapter.submitList(movies)
    }

    override fun showTopMovies(movies: List<Movie>) {
        movieListAdapter.submitList(movies)
    }

    override fun showError(t: Throwable) {
    }

    companion object {
        fun newInstance(): ListFragment {
            return ListFragment()
        }
    }
}
