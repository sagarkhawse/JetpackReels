package com.laboontech.instagramreelclone.presentation.components

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory

@Composable
fun VideoPlayer(
    videoUrl: String,
    isVisible: Boolean,
) {
    val context = LocalContext.current
    val TAG = "SagarTest"

    // Make a video player builder
    val videoPlayer = remember {
        ExoPlayer.Builder(context)
            .build()
            .apply {
                val mediaSource = ProgressiveMediaSource
                    .Factory(DefaultDataSourceFactory(context, "InstagramReelClone"))
                    .createMediaSource(MediaItem.fromUri(Uri.parse(videoUrl)))
                this.setMediaSource(mediaSource, true)
                this.prepare()
                videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
                repeatMode = Player.REPEAT_MODE_ONE

            }
    }

    // Use AndroidView to inflate the video player
    AndroidView({
        PlayerView(it).apply {
            useController = false
            player = videoPlayer
            resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FILL
        }
    })

    // Start exoplayer when it is ready to play
    videoPlayer.playWhenReady = isVisible

    // Add a lifecycle owner to video player so that it can be stopped when app is in background or minimize
    val lifecycleOwner = rememberUpdatedState(newValue = LocalLifecycleOwner.current)

    DisposableEffect(key1 = videoUrl) {
        val observer = LifecycleEventObserver { source: LifecycleOwner, event: Lifecycle.Event ->
            when (event) {
                Lifecycle.Event.ON_PAUSE -> {
                    videoPlayer.pause()
                }

                Lifecycle.Event.ON_RESUME -> {
                    videoPlayer.play()
                }

                else -> {}
            }
        }

        // add observer to lifecycle to listen lifecycle events
        val lifecycle = lifecycleOwner.value.lifecycle
        lifecycle.addObserver(observer)

        // Dispose observer and video player
        onDispose {
            videoPlayer.release()
            lifecycle.removeObserver(observer)
        }
    }
}
