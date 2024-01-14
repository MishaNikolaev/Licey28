package com.example.yourlicey28.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.yourlicey28.R

@Composable
fun HomeTabRowCard() {
    val scrollState = rememberScrollState()
    Row(modifier = Modifier.horizontalScroll(scrollState)) {
        Image(
            painter = painterResource(id = R.drawable._class),
            contentDescription = "Welcome Illustration",
            modifier = Modifier
                .width(132.dp)
                .height(132.dp)
                .background(Color.White)
                .clickable(
                    enabled = true,
                    onClickLabel = "Clickable image",
                    onClick = {
                    }
                )
        )
        Image(
            painter = painterResource(id = R.drawable._0class),
            contentDescription = "Welcome Illustration",
            modifier = Modifier
                .width(132.dp)
                .height(132.dp)
                .background(Color.White)
                .clickable(
                    enabled = true,
                    onClickLabel = "Clickable image",
                    onClick = {
                    }
                )
        )


        Image(
            painter = painterResource(id = R.drawable.gia_2),
            contentDescription = "Welcome Illustration",
            modifier = Modifier
                .width(132.dp)
                .height(132.dp)
                .background(Color.White)
                .clickable(
                    enabled = true,
                    onClickLabel = "Clickable image",
                    onClick = {
                    }
                )
        )

    }
}