package com.example.irokutest.ui.player

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import com.example.irokutest.App
import com.example.irokutest.R
import com.example.irokutest.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_player.*


/**
 * Movie Player class to play trailers
 */
class PlayerFragment : BaseFragment<PlayerPresenter, PlayerView>(), PlayerView {

    override val layoutID = R.layout.fragment_player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.instance.appComponent.inject(this)
    }

    override fun setPlayer() {
        presenter.setUpPlayer()
        player_view.player = presenter.player
    }

    override fun hideSystemUi() {
        @SuppressLint("InlinedApi")
        player_view.systemUiVisibility = (View.SYSTEM_UI_FLAG_LOW_PROFILE
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
    }

    companion object {
        fun newInstance() = PlayerFragment()
    }
}
