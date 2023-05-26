package com.laboontech.instagramreelclone.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState
import com.laboontech.instagramreelclone.domain.model.VideoModel
import com.laboontech.instagramreelclone.presentation.components.BottomBarComponent
import com.laboontech.instagramreelclone.presentation.components.IconContentComponent
import com.laboontech.instagramreelclone.presentation.components.UserDetailComponent
import com.laboontech.instagramreelclone.presentation.components.VideoPlayer

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
@Composable
fun VideoPlayerScreen(
    viewModel: VideoInfoViewModel = hiltViewModel(),
) {
    val state = viewModel.state

    val videoList = state.videos.shuffled()
    val pagerState = rememberPagerState()

    Scaffold(
        bottomBar = {
            BottomBarComponent()
        },
    ) {
        Box(modifier = Modifier.padding(it)) {
            // Vertical Pager list - Vertical scrolling of videos
            VerticalPager(
                count = videoList.size,
                state = pagerState,
            ) { currentPage ->

                // get video data item from list
                val videoItem = videoList[currentPage]
                // add condition to know the current selected video - only visible video will play
                val isSelected = pagerState.currentPage == currentPage

                // Video Ui Item
                PagerItemUi(
                    videoItem = videoItem,
                    isSelected = isSelected,
                )
            }
        }
    }
}

@Composable
fun PagerItemUi(videoItem: VideoModel, isSelected: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        VideoPlayer(videoUrl = videoItem.videoUrl, isVisible = isSelected)
        VideoOverlayUI(videoItem)
    }
}

@Composable
fun VideoOverlayUI(videoItem: VideoModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            UserDetailComponent(Modifier.weight(1f).align(Alignment.Bottom))
            IconContentComponent()
        }
    }
}

@Preview()
@Composable
fun VideoPlayerScreenPreview() {
    VideoPlayerScreen()
}
