package com.example.irokutest.ui.main

import com.example.irokutest.ui.base.BaseFragment


class MainFragment : BaseFragment<MainPresenter, MainView>(), MainView {

    companion object {
        const val DIALOG_TAG = "MAIN_FRAGMENT_TAG"
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    override fun showError(t: Throwable) {
    }
}
