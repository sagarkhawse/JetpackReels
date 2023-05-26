package com.laboontech.instagramreelclone.data.remote.dto

data class VideoResponseDto(
    val error: Boolean,
    val res: List<VideoDto>,
    val error_msg: String,
)
