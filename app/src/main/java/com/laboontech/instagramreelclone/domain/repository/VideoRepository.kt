package com.laboontech.instagramreelclone.domain.repository

import com.laboontech.instagramreelclone.domain.model.VideoModel
import com.laboontech.instagramreelclone.utils.Resource
import kotlinx.coroutines.flow.Flow

interface VideoRepository {

    suspend fun getVideoList(): Flow<Resource<List<VideoModel>>>
}
