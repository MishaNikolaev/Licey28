package com.example.yourlicey28.presentation.homeScreen.nabor1class

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yourlicey28.R
import com.example.yourlicey28.navgraph.ProfileGraphScreen
import com.example.yourlicey28.ui.theme.robotoFamily

@Composable
fun NaborFirstClass() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Image(
            painter = painterResource(id = R.drawable.frame_610),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(144.dp)
        )
        Text(
            text = "Планируется набор четырёх первых классов общей наполняемостью 120 человек. Предварительная запись производится по вторникам и четвергам с 8:30 до 11:30 по телефону 271-98-41. ",
            modifier = Modifier.padding(top = 20.dp,start=10.dp,end=10.dp),
            fontFamily = robotoFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            color = Color.Black
        )

        Text(
            text = "Подать документы на прием в 1 класс одним из следующих способов: \n" +
                    "1) Лично в образовательную организацию (по предварительной записи)",
            modifier = Modifier.padding(top = 20.dp,start=10.dp,end=10.dp),
            fontFamily = robotoFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
}