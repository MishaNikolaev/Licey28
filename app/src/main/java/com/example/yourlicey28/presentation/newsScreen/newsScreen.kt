package com.example.yourlicey28.presentation.newsScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
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
                Image(
                    painter = painterResource(id = R.drawable.school_image),
                    contentDescription = "Welcome Illustration",
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .fillMaxHeight(0.2f)
                )
                Text(
                    text = "Жизнь лицея",
                    modifier = Modifier.padding(top = 5.dp,start=20.dp),
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                NewsCard()
            }
        }
    }
}
