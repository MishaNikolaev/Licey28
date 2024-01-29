package com.example.yourlicey28.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.yourlicey28.R
import com.example.yourlicey28.navgraph.ProfileGraphScreen
import com.example.yourlicey28.ui.theme.LightGreen
import com.example.yourlicey28.ui.theme.Orange
import com.example.yourlicey28.ui.theme.Pink
import com.example.yourlicey28.ui.theme.Purple
import com.example.yourlicey28.ui.theme.robotoFamily

@Composable
fun ProfileCard(onClickProfileCard:() -> Unit) {
    val navController = rememberNavController()
    Column() {
        Row() {
            Box(
                modifier = Modifier
                    .shadow(elevation = 20.dp)
                    .clickable(
                        enabled = true,
                        onClickLabel = "Clickable image",
                        onClick = onClickProfileCard
                    )
                    .size(150.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Pink)
            ) {
                Text(
                    text = "Кружки и" +
                            "\nдополнительные" +
                            "\nзанятия",
                    modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color.White
                )
                Text(
                    text =
                    "Получай новые знания" +
                            "\nв внеурочное" +
                            "\nвремя.",
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 5.dp, top = 35.dp),
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    color = Color.White
                )
                Image(
                    painter = painterResource(id = R.drawable.icon1_profilescreen),
                    contentDescription = "Welcome Illustration",
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .width(60.dp)
                        .height(60.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(modifier = Modifier
                .shadow(elevation = 20.dp)
                .clickable(
                    enabled = true,
                    onClickLabel = "Clickable image",
                    onClick = onClickProfileCard
                )
                .size(150.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Purple)) {
                Text(
                    text = "Мои учителя",
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color.White
                )
                Text(
                    text =
                    "Внимательно слушай и" +
                            "\nследуй их советам.",
                    modifier = Modifier.padding(start = 10.dp, top = 40.dp),
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    color = Color.White
                )
                Image(
                    painter = painterResource(id = R.drawable.icon3_profilescreen),
                    contentDescription = "Welcome Illustration",
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .width(70.dp)
                        .height(70.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row() {
            Box(modifier = Modifier
                .shadow(elevation = 20.dp)
                .clickable(
                    enabled = true,
                    onClickLabel = "Clickable image",
                    onClick = onClickProfileCard
                )
                .size(150.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(LightGreen)) {
                Text(
                    text = "Развиваем" +
                            "\nприложение",
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color.White
                )
                Text(
                    text =
                    "Предлагай свои идеи.",
                    modifier = Modifier.padding(start = 10.dp, top = 60.dp),
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    color = Color.White
                )
                Image(
                    painter = painterResource(id = R.drawable.icon3_profilescreen),
                    contentDescription = "Welcome Illustration",
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .width(60.dp)
                        .height(60.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(modifier = Modifier
                .shadow(elevation = 20.dp)
                .clickable(
                    enabled = true,
                    onClickLabel = "Clickable image",
                    onClick = onClickProfileCard
                )
                .size(150.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Orange)) {
                Text(
                    text = "Расписание звонков",
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color.White
                )
                Text(
                    text =
                    "Следи за расписанием" +
                            "\nзвонков. Образцовый" +
                            "\nлицеист не пропускает" +
                            "\nзанятия.",
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 10.dp, top = 10.dp),
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    color = Color.White
                )
                Image(
                    painter = painterResource(id = R.drawable.icon4_profilescreen),
                    contentDescription = "Welcome Illustration",
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .width(60.dp)
                        .height(60.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
            }
        }
    }
}