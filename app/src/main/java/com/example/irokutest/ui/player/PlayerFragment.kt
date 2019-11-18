package com.example.irokutest.ui.player

import android.os.Bundle
import com.example.irokutest.App
import com.example.irokutest.R
import com.example.irokutest.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_detail.*


class PlayerFragment : BaseFragment<PlayerPresenter, PlayerView>(), PlayerView {

    override val layoutID = R.layout.fragment_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.instance.appComponent.inject(this)

    }

    override fun setUpListeners() {
        super.setUpListeners()

        image.setOnClickListener { }
    }

    companion object {
        const val ARG_MOVIE_ID = "ARG_MOVIE_ID"

        fun newInstance(movieId: Int): PlayerFragment {
            return PlayerFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_MOVIE_ID, movieId)
                }
            }
        }
    }
}
