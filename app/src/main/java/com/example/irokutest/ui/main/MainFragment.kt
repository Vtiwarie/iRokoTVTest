package com.example.irokutest.ui.main

import android.os.Bundle
import com.example.irokutest.App
import com.example.irokutest.R
import com.example.irokutest.ui.base.BaseFragment


class MainFragment : BaseFragment<MainPresenter, MainView>(), MainView {

    override val layoutID = R.layout.fragment_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.instance.appComponent.inject(this)
    }

    override fun showError(t: Throwable) {
    }

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }
}
