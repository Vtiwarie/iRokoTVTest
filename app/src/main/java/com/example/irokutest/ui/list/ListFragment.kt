package com.example.irokutest.ui.list

import android.os.Bundle
import com.example.irokutest.App
import com.example.irokutest.R
import com.example.irokutest.ui.base.BaseFragment


class ListFragment : BaseFragment<ListPresenter, ListView>(), ListView {

    override val layoutID = R.layout.fragment_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.instance.appComponent.inject(this)
    }

    override fun showPopularMovies() {
    }

    override fun showTopMovies() {
    }

    override fun initializeViews() {
    }

    override fun showError(t: Throwable) {
    }

    companion object {
        fun newInstance(): ListFragment {
            return ListFragment()
        }
    }
}
