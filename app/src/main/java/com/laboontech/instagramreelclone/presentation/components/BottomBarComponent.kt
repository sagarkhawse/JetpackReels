package com.laboontech.instagramreelclone.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.laboontech.instagramreelclone.R

@Composable
fun BottomBarComponent() {
    BottomAppBar(
        containerColor = Color.Black,
        contentColor = Color.White,
        modifier = Modifier.height(50.dp),
    ) {
        Icon(
            modifier = Modifier.size(26.dp).weight(1f),
            painter = painterResource(id = R.drawable.ic_home),
            contentDescription = "Home",
        )
        Icon(
            modifier = Modifier.size(26.dp).weight(1f),
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
        )
        Icon(
            modifier = Modifier.size(26.dp).weight(1f),
            painter = painterResource(id = R.drawable.ic_add),
            contentDescription = "Add",
        )
        Icon(
            modifier = Modifier.size(42.dp).weight(1f),
            painter = painterResource(id = R.drawable.ic_reel),
            contentDescription = "Reel",
        )
        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
            Image(
                modifier = Modifier.size(33.dp).background(Color.White, CircleShape)
                    .padding(2.dp),
                painter = painterResource(id = R.drawable.naruto),
                contentDescription = "Profile",
            )
        }
    }
}
