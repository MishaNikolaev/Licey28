package com.example.yourlicey28.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yourlicey28.R

@Composable
fun NewsCard() {
    Column() {
        Box {
            Image(
                painter = painterResource(id = R.drawable.frame_613),
                contentDescription = "Welcome Illustration",
                modifier = Modifier.padding()
                    .width(400.dp)
                    .height(400.dp)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.frame_613),
            contentDescription = "Welcome Illustration",
            modifier = Modifier.padding()
                .width(400.dp)
                .height(400.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.frame_613),
            contentDescription = "Welcome Illustration",
            modifier = Modifier.padding()
                .width(400.dp)
                .height(400.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.frame_613),
            contentDescription = "Welcome Illustration",
            modifier = Modifier.padding()
                .width(400.dp)
                .height(400.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.frame_613),
            contentDescription = "Welcome Illustration",
            modifier = Modifier.padding()
                .width(400.dp)
                .height(400.dp)
        )
    }
}