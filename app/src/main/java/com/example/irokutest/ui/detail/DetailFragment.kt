package com.example.irokutest.ui.detail

import android.os.Bundle
import com.example.irokutest.App
import com.example.irokutest.R
import com.example.irokutest.model.Movie
import com.example.irokutest.ui.base.BaseFragment


class DetailFragment : BaseFragment<DetailPresenter, DetailView>(), DetailView {

    override val layoutID = R.layout.fragment_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.instance.appComponent.inject(this)
    }

    override fun showMovieDetails(movie: Movie) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initializeViews() {
    }

    override fun showError(t: Throwable) {
    }

    companion object {
        fun newInstance(): DetailFragment {
            return DetailFragment()
        }
    }
}
