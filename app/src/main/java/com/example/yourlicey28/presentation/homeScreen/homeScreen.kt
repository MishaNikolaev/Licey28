package com.example.yourlicey28.presentation.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yourlicey28.R
import com.example.yourlicey28.presentation.components.HomeTabRowCard
import com.example.yourlicey28.presentation.components.ProfileCard
import com.example.yourlicey28.presentation.components.ProfileTabRowCard
import com.example.yourlicey28.ui.theme.robotoFamily

@Composable
fun HomeScreen() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Color.White
                )
                .padding(16.dp)
        ) {
            Column() {
                Spacer(modifier = Modifier.height(16.dp))
                HomeTabRowCard()
                Spacer(modifier = Modifier.height(16.dp))
                Column(modifier = Modifier.align(CenterHorizontally)) {
                    Image(
                        painter = painterResource(id = R.drawable.ondevelop),
                        contentDescription = "Welcome Illustration",
                        modifier = Modifier
                            .width(256.dp)
                            .height(256.dp)
                            .background(Color.White)
                            .clickable(
                                enabled = true,
                                onClickLabel = "Clickable image",
                                onClick = {
                                }
                            )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ondevelop),
                        contentDescription = "Welcome Illustration",
                        modifier = Modifier
                            .width(256.dp)
                            .height(256.dp)
                            .background(Color.White)
                            .clickable(
                                enabled = true,
                                onClickLabel = "Clickable image",
                                onClick = {
                                }
                            )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ondevelop),
                        contentDescription = "Welcome Illustration",
                        modifier = Modifier
                            .width(256.dp)
                            .height(256.dp)
                            .background(Color.White)
                            .clickable(
                                enabled = true,
                                onClickLabel = "Clickable image",
                                onClick = {
                                }
                            )
                    )
                }
            }
        }
    }
}