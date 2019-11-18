package com.example.irokutest.ui.detail

import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.irokutest.App
import com.example.irokutest.R
import com.example.irokutest.model.Movie
import com.example.irokutest.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : BaseFragment<DetailPresenter, DetailView>(), DetailView {

    override val layoutID = R.layout.fragment_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.instance.appComponent.inject(this)

        presenter.movieId = arguments?.getInt(ARG_MOVIE_ID) ?: return
    }

    override fun setUpListeners() {
        super.setUpListeners()

        image.setOnClickListener {  }
    }

    override fun showMovieDetails(movie: Movie) {
        val baseImageUrl = context?.getString(R.string.image_base_url)

        Glide.with(view!!)
            .load("${baseImageUrl}${movie.poster_path}")
            .into(image)

        title.text = movie.title
        synopsis.text = movie.overview
        rating.text = movie.vote_average.toString()
    }

    companion object {
        const val ARG_MOVIE_ID = "ARG_MOVIE_ID"

        fun newInstance(movieId: Int): DetailFragment {
            return DetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_MOVIE_ID, movieId)
                }
            }
        }
    }
}
