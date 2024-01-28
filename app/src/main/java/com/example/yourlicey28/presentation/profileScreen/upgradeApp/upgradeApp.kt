package com.example.yourlicey28.presentation.profileScreen.upgradeApp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yourlicey28.R
import com.example.yourlicey28.ui.theme.robotoFamily

@Composable
fun UpgradeApp() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Text(
            text = "Развиваем приложение",
            modifier = Modifier.padding(start = 10.dp, top = 10.dp),
            fontFamily = robotoFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            color = Color.Black
        )
            Image(
                painter = painterResource(id = R.drawable.rectangle_88),
                contentDescription = "Welcome Illustration",
                modifier = Modifier.padding(top=10.dp)
                    .fillMaxWidth()
                    .height(256.dp)

            )
        Text(
            text = "Благодаря вашим предложениям, мобильное приложение будет улучшаться. Вы можете написать свои идеи на почту - nmichail154@mail.ru",
            modifier = Modifier.padding(start = 10.dp, top = 10.dp),
            fontFamily = robotoFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            color = Color.Black
        )
    }
}