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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yourlicey28.R
import kotlinx.coroutines.delay

@Composable
fun CarouselNewsBar() {
    val Images = listOf (

        R.drawable.school_image,
        R.drawable.school2,
        R.drawable.y490qsnrc_i,
        R.drawable.school_image
    )
    ImageSliderWithIndicator(images = Images)
}

@Composable
fun ImageSliderItem(imageRes: Int) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
    )
}

@Composable
fun Indicator(active: Boolean) {
    val color = if (active) Color.LightGray else Color.Gray
    val size = if (active) 10.dp else 10.dp
    Box(modifier = Modifier
        .clip(CircleShape)
        .background(color)
        .size(size))
}

@Composable
fun ImageSliderWithIndicator(images: List<Int>) {
    val currentIndex = remember {
        mutableStateOf(0)
    }
    LaunchedEffect(Unit) {
        while (true) {
            delay(3000)
            currentIndex.value = (currentIndex.value + 1) % images.size
        }
    }
    Column(modifier = Modifier.fillMaxWidth()){
        Box(modifier = Modifier
            .weight(1f)){
            ImageSliderItem(imageRes = images[currentIndex.value])
        }
        Row(modifier = Modifier.padding(start=170.dp,bottom = 550.dp)){
            images.forEachIndexed{ index, i ->
                Indicator(active = index == currentIndex.value)
                if (index < images.size - 1){
                    Spacer(modifier = Modifier.width(5.dp))
                }
            }
        }
    }
}