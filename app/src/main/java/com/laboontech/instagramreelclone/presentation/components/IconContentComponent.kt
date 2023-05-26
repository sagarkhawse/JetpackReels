package com.laboontech.instagramreelclone.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.laboontech.instagramreelclone.R

@Composable
fun IconContentComponent() {
    // Icon content
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Like Section
        Image(
            modifier = Modifier.size(40.dp),
            painter = painterResource(id = R.drawable.ic_like),
            contentDescription = "Like",
        )
        Text(
            text = "809k",
            color = Color.White,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Comment section
        Image(
            modifier = Modifier.size(40.dp),
            painter = painterResource(id = R.drawable.ic_comment),
            contentDescription = "Comment",
        )
        Text(
            text = "3,907",
            color = Color.White,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Share section
        Image(
            modifier = Modifier.size(40.dp),
            painter = painterResource(id = R.drawable.ic_share),
            contentDescription = "Share",
        )
        Text(
            text = "1.8M",
            color = Color.White,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        // More menu
        Image(
            painter = painterResource(id = R.drawable.ic_more),
            contentDescription = "Menu",
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Song Card
        Image(
            modifier = Modifier
                .size(34.dp)
                .border(2.dp, Color.White, RoundedCornerShape(5.dp)),
            painter = painterResource(id = R.drawable.naruto),
            contentDescription = "Song Icon",
            contentScale = ContentScale.Crop,
        )

        Spacer(modifier = Modifier.height(10.dp))
    }
}
