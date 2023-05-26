package com.laboontech.instagramreelclone.presentation

import com.laboontech.instagramreelclone.domain.model.VideoModel

data class VideoListState(
    val videos: List<VideoModel> = emptyList(),
    val isLoading: Boolean = false,
    var error_msg: String = "Error",
)
