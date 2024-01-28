package com.example.yourlicey28.presentation.profileScreen.ntoSchool

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale.Companion.FillWidth
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yourlicey28.R
import com.example.yourlicey28.ui.theme.Blue
import com.example.yourlicey28.ui.theme.robotoFamily


@Composable
fun NtoSchool(){
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Image(
            painter = painterResource(id = R.drawable.nto6),
            contentDescription = "Welcome Illustration",
            modifier = Modifier
                    . fillMaxWidth ()
                .fillMaxHeight(0.5f)

        )
        Text(
            text = "Национальная технологическая олимпиада — командные инженерные соревнования для школьников и студентов. Объединяет тех, кто хочет быть востребованным и решать действительно важные задачи с помощью современных технологий.",
            modifier = Modifier.padding(start = 10.dp,top=10.dp),
            fontFamily = robotoFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = Color.Black
        )
        Image(
            painter = painterResource(id = R.drawable.rectangle_8),
            contentDescription = "Welcome Illustration",
            modifier = Modifier
                .padding(start = 30.dp)
                .width(300.dp)
                .height(300.dp)

        )
        Text(
            text = "Осваивай современные технологии. Решай только актуальные задачи. Выясни, кем хочешь стать. Поступай в передовые вузы. Стань тем, кем мечтаешь!",
            modifier = Modifier.padding(start = 10.dp),
            fontFamily = robotoFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = Color.Black
        )
        Image(
            painter = painterResource(id = R.drawable.nto5),
            contentDescription = "Welcome Illustration",
            modifier = Modifier
                .padding(start = 30.dp)
                .width(300.dp)
                .height(300.dp)

        )
        Text(
            text = "Национальная технологическая олимпиада Junior:",
            modifier = Modifier.padding(start = 10.dp),
            fontFamily = robotoFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = Color.Black
        )
        ClickableLink(url = "https://junior.ntcontest.ru/")

        Text(
            text = "Национальная технологическая олимпиада школьников 8-11 класс:",
            modifier = Modifier.padding(start = 10.dp),
            fontFamily = robotoFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = Color.Black
        )
        ClickableLink(url = "https://ntcontest.ru/tracks/nto-school/")

        Text(
            text = "МБОУ Лицей №28 получил официальный статус площадки подготовки НТО.",
            modifier = Modifier.padding(start = 10.dp),
            fontFamily = robotoFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = Color.Black
        )
        ClickableLink(url = "https://ntcontest.ru/study/area/?filter%5Bcity%5D%5B%5D=&filter%5Bcity%5D%5B%5D=1541")
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
