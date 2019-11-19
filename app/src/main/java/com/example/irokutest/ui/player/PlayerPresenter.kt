package com.example.irokutest.ui.player

import android.net.Uri
import com.example.irokutest.App
import com.example.irokutest.classes.MediaSourceBuilder
import com.example.irokutest.ui.base.BasePresenter
import com.google.android.exoplayer2.DefaultLoadControl
import com.google.android.exoplayer2.DefaultRenderersFactory
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import javax.inject.Inject

/**
 * @author Vishaan Tiwarie
 *
 * PlayerFragment Presenter
 */
class PlayerPresenter @Inject constructor() :
    BasePresenter<PlayerView>() {

    var playVideoWhenReady = true
    var currentPosition = 0L
    var currUri: Uri =
//        Uri.parse("https://sample-videos.com/video123/mp4/480/big_buck_bunny_480p_5mb.mp4")
        Uri.parse("http://techslides.com/demos/sample-videos/small.mp4")
    var player: SimpleExoPlayer? = null

    fun setUpPlayer() {
        if (player == null) {
            player = ExoPlayerFactory.newSimpleInstance(
                App.instance.applicationContext,
                DefaultRenderersFactory(App.instance.applicationContext),
                DefaultTrackSelector(),
                DefaultLoadControl()
            )
        }

        player?.playWhenReady = playVideoWhenReady
        player?.seekTo(currentPosition)
    }

    override fun start() {
        player?.playWhenReady = true
        player?.playbackState
    }

    override fun stop() {
        releasePlayer()
        player?.stop()
    }

    override fun resume() {
        player?.playWhenReady = true
        loadState()
        play(currUri)
    }

    override fun pause() {
        player?.playWhenReady = false
        player?.playbackState
        saveState()
    }

    fun play(uri: Uri?) {
        if (uri == null) return
        currUri = uri
        view?.setPlayer()
        preparePlayer(uri)
        view?.hideSystemUi()
    }

    private fun preparePlayer(uri: Uri) {
        val mediaSource = MediaSourceBuilder().build(uri)
        player?.prepare(mediaSource, true, false)
    }

    private fun saveState() {
        if (player != null) {
            currentPosition = player?.currentPosition ?: 0L
            playVideoWhenReady = player?.playWhenReady ?: true
        }
    }

    private fun loadState() {
        player?.apply {
            this.playWhenReady = playVideoWhenReady
            this.seekTo(currentWindowIndex, currentPosition)
        }
    }

    private fun releasePlayer() {
        if (player != null) {
            saveState()
            player?.release()
            player = null
        }
    }

    companion object {
        const val TAG = "PlayerPresenter"
    }
}