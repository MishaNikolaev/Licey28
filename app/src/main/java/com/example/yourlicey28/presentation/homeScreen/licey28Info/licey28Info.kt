package com.example.yourlicey28.presentation.homeScreen.licey28Info

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
fun Licey28Info() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(
                text = "Сведения об образовательной\n" +
                        "организации",
                modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                fontFamily = robotoFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                color = Color.Black
            )
        }
        Image(
            painter = painterResource(id = R.drawable.rectangle_20__1_),
            contentDescription = "Welcome Illustration",
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
                .height(256.dp)

        )
        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(
                text = "Дата создания образовательного\n" +
                        "учреждения: 01.09.1971г",
                modifier = Modifier.padding(top = 30.dp),
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                color = Color.Black
            )
        }
        Image(
            painter = painterResource(id = R.drawable.rectangle_21),
            contentDescription = "Welcome Illustration",
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
                .height(256.dp)

        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Организация не имеет филиалов Организация не имеет представительств.",
            modifier = Modifier.padding(top = 10.dp, start = 20.dp),
            fontFamily = robotoFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            color = Color.Black
        )

        Text(
            text = "Адрес: 630110 г.Новосибирск, \n" +
                    "ул.Новая Заря, 27.Проезд всеми видами транспорта до ост.\"ул.О. Дундича\"",
            modifier = Modifier.padding(top = 30.dp, start = 20.dp),
            fontFamily = robotoFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            color = Color.Black
        )
        Text(
            text = "e-mail: l_28@edu54.ru",
            modifier = Modifier.padding(top = 30.dp,start=20.dp),
            fontFamily = robotoFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            color = Color.Black
        )

        Text(
            text = "График работы:" +
                    "\nПонедельник - суббота с 8:00 до 19:30\n" +
                    "Воскресенье – выходной.",
            modifier = Modifier.padding(top = 30.dp,start=20.dp),
            fontFamily = robotoFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            color = Color.Black
        )

        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Image(
                painter = painterResource(id = R.drawable.rectangle_22),
                contentDescription = "Welcome Illustration",
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .height(256.dp)

            )
        }
        Text(
            text = "Режим работы:\n" +
                    "1 класс-5-ти дневная учебная неделя\n" +
                    "2-11 класс-6-ти дневная учебная неделя\n" +
                    "1 смена – 1, 4, 5, 8, 9, 10, 11 классы\n" +
                    "2 смена – 2, 3, 6, 7 классы",
            modifier = Modifier.padding(top = 30.dp,start=20.dp),
            fontFamily = robotoFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
}