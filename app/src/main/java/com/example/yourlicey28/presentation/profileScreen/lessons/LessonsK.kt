package com.example.yourlicey28.presentation.profileScreen.lessons

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yourlicey28.R
import com.example.yourlicey28.presentation.components.Kruzhok28CarouselBar
import com.example.yourlicey28.ui.theme.Blue
import com.example.yourlicey28.ui.theme.robotoFamily

@Composable
fun LessonsKruzhki() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Box(modifier = Modifier.align(CenterHorizontally)) {
            Text(
                text = "Кружки и дополнительные занятия",
                modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                fontFamily = robotoFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                color = Color.Black
            )
        }
        Text(
            text = "Кружок28",
            modifier = Modifier.padding(start = 10.dp, top = 10.dp),
            fontFamily = robotoFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 22.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.padding(top=20.dp))
        Kruzhok28CarouselBar()
        Spacer(modifier = Modifier.padding(top=20.dp))
        Text(
            text = "МБОУ Лицей №28 получил статус официальной площадки НТО. На занятиях кружковцы индивидуально или в составе группы работают над отдельными (у каждого кружковца/группы разные) учебными или соревновательными задачами. Преподаватели разбирают материал с такими группами, последовательно переключаясь между ними. Такой формат позволяет каждому ученику развиваться по своей собственной траектории, которая обсуждается с каждым учеником в начале и середине учебного года.",
            modifier = Modifier.padding(start = 10.dp),
            fontFamily = robotoFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = Color.Black
        )
        Image(
            painter = painterResource(id = R.drawable.kruzhok28_5),
            contentDescription = "Welcome Illustration",
            modifier = Modifier
                .fillMaxWidth()
                .height(256.dp)

        )
        Box(modifier = Modifier.align(CenterHorizontally)) {
            Text(
                text = "Расписание занятий:",
                modifier = Modifier.padding(),
                fontFamily = robotoFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = Color.Black
            )
            Text(
                text = "Вторник и пятница\n" +
                        "16:30 – 18:30, \n" +
                        "перерыв 19:00 – 20:30",
                modifier = Modifier.padding(top = 30.dp),
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                color = Color.Black
            )
        }
        Text(
            text = "Запись происходит на сайте кружка28 -",
            modifier = Modifier.padding(start = 10.dp),
            fontFamily = robotoFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            color = Color.Black
        )
        ClickableLink(url = "https://kruzhok28.ydns.eu/posts/info")
        Spacer(modifier = Modifier.height(20.dp))

    }
}


@Composable
fun ClickableLink(url: String) {
    val uriHandler = LocalUriHandler.current
    val annotatedString = buildAnnotatedString {
        append(url)
        addStyle(
            style = SpanStyle(
                color = Blue,
                textDecoration = TextDecoration.Underline
            ),
            start = 0,
            end = url.length
        )
    }

    Text(
        text = annotatedString,
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        modifier = Modifier
            .padding(start = 10.dp)
            .clickable { uriHandler.openUri(url) }
    )
}