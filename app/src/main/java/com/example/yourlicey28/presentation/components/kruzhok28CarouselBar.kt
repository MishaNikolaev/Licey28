package com.example.yourlicey28.presentation.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yourlicey28.R
import com.example.yourlicey28.presentation.newsScreen.RoundedImageWithText
import com.example.yourlicey28.ui.theme.robotoFamily
import kotlinx.coroutines.delay

@Composable
fun Kruzhok28CarouselBar() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        ImageCarousel(
            images = listOf(
                painterResource(id = R.drawable.kruzhok28_1),
                painterResource(id = R.drawable.kruzhok28_2),
                painterResource(id = R.drawable.kruzhok28_3),
                painterResource(id = R.drawable.kruzhok28_4)
            ),
            intervalMillis = 3000
        )
    }
}

@Composable
fun ImageCarousel(images: List<Painter>, intervalMillis: Int) {
    var currentIndex by remember { mutableStateOf(0) }
    val listState = rememberLazyListState()
    LaunchedEffect(true) {
        while (true) {
            delay(intervalMillis.toLong())
            currentIndex = (currentIndex + 1) % images.size
            listState.animateScrollToItem(currentIndex)
        }
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            LazyRow(state = listState) {
                items(images) { image ->
                    Image(
                        painter = image,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(256.dp)
                    )
                }
            }
        }
    }
}
