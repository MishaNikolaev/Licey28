package com.example.yourlicey28.presentation.profileScreen.timeTableZvonkov

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yourlicey28.R
import com.example.yourlicey28.presentation.components.Kruzhok28CarouselBar
import com.example.yourlicey28.presentation.profileScreen.lessons.ClickableLink
import com.example.yourlicey28.ui.theme.robotoFamily

@Composable
fun TimeTableZvokov(){
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(
                text = "Расписание звонков",
                modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                fontFamily = robotoFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                color = Color.Black
            )
        }
        Image(
            painter = painterResource(id = R.drawable.rectangle_17),
            contentDescription = "Welcome Illustration",
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
                .height(256.dp)

        )
        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(
                text = "         1 смена",
                modifier = Modifier.padding(),
                fontFamily = robotoFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                color = Color.Black
            )
            Text(
                text = "1 урок) 8:00 - 8:40\n" +
                        "2 урок) 8:50 - 9:30\n" +
                        "3 урок) 9:50 - 10:30\n" +
                        "4 урок) 10:50 - 11:30\n" +
                        "5 урок) 11:40 - 12:20\n" +
                        "6 урок) 12:30 - 13:10",
                modifier = Modifier.padding(top = 30.dp),
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(
                text = "         2 смена",
                modifier = Modifier.padding(),
                fontFamily = robotoFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                color = Color.Black
            )
            Text(
                text = "1 урок) 13:40 - 14:20\n" +
                        "2 урок) 14:40 - 15:20\n" +
                        "3 урок) 15:40 - 16:20\n" +
                        "4 урок) 16:30 - 17:10\n" +
                        "5 урок) 17:20 - 18:00\n" +
                        "6 урок) 18:10 - 18:50",
                modifier = Modifier.padding(top = 30.dp),
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}


