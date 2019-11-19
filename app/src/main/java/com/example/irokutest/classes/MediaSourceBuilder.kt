package com.example.irokutest.classes

import android.net.Uri
import com.example.irokutest.Constants
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.dash.DashMediaSource
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory

class MediaSourceBuilder {

    //Build various MediaSource depending upon the type of Media for a given video/audio uri
    fun build(uri: Uri): MediaSource {
        val userAgent = Constants.Player.USER_AGENT
        val lastPath = uri.lastPathSegment ?: ""

        val defaultHttpDataSourceFactory = DefaultHttpDataSourceFactory(userAgent)

        if (lastPath.contains(Constants.Player.FORMAT_MP3) || lastPath.contains(Constants.Player.FORMAT_MP4)) {

            return ExtractorMediaSource.Factory(defaultHttpDataSourceFactory)
                .createMediaSource(uri)

        } else if (lastPath.contains(Constants.Player.FORMAT_M3U8)) {

            return HlsMediaSource.Factory(defaultHttpDataSourceFactory)
                .createMediaSource(uri)

        } else {
            val dashChunkSourceFactory =
                DefaultDashChunkSource.Factory(defaultHttpDataSourceFactory)

            return DashMediaSource.Factory(dashChunkSourceFactory, defaultHttpDataSourceFactory)
                .createMediaSource(uri)

        }
    }
}