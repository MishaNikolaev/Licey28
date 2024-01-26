package com.example.yourlicey28.presentation.newsScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import com.example.yourlicey28.R
import com.example.yourlicey28.presentation.components.NewsCard
import com.example.yourlicey28.presentation.components.ProfileCard
import com.example.yourlicey28.presentation.components.ProfileTabRowCard
import com.example.yourlicey28.ui.theme.robotoFamily
import kotlinx.coroutines.delay
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NewsScreen() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Color.White
                )
        ) {
            Column() {
                NewsTopBar()
                NewsCard()
            }
        }
    }
}

@Composable
fun NewsTopBar() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        ImageCarousel(
            images = listOf(
                painterResource(id = R.drawable.school_image),
                painterResource(id = R.drawable.school2),
                painterResource(id = R.drawable.y490qsnrc_i),
                painterResource(id = R.drawable.school4)
            ),
            intervalMillis = 5000
        )
    }
    RoundedImageWithText()
    Text(
        text = "Жизнь лицея",
        modifier = Modifier.padding(top = 5.dp, start = 20.dp),
        fontFamily = robotoFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        color = Color.Black
    )
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
// Page Indicators
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(images.size) { index ->
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .size(10.dp)
                    .background(
                        color = if (index == currentIndex) Color.White else Color.LightGray,
                        shape = CircleShape
                    )
            )
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
                            .width(400.dp)
                            .height(300.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun RoundedImageWithText(
) {
    Box(
        modifier = Modifier.height(100.dp).padding(start=25.dp)
            .fillMaxWidth(0.9f)
            .clip(RoundedCornerShape(20.dp))
    ) {
        Image(
            painter = painterResource(id =R.drawable._613301682_96_p_sinii_fon_abstraktsiya_geometriya_140),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize().clickable(
                enabled = true,
                onClickLabel = "Clickable image",
                onClick = {
                }
            )
        )
        Text(
            text = "Олимпиада НТО" +
                    "\nЗаписывайся в кружок28!",
            color = Color.White,
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp),
            fontFamily = robotoFamily,
            fontWeight = FontWeight.SemiBold,
        )
    }
}