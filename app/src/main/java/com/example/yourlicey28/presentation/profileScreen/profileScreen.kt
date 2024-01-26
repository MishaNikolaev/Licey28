package com.example.yourlicey28.presentation.profileScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yourlicey28.R
import com.example.yourlicey28.presentation.components.ProfileTabRowCard
import com.example.yourlicey28.ui.theme.robotoFamily
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items

import androidx.compose.material.*
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Card
import androidx.compose.material3.Surface


import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import com.example.yourlicey28.presentation.components.ProfileCard


@Composable
fun ProfileScreen(onClick:()->Unit) {
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
                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    modifier = Modifier.horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.Start,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.person),
                        contentDescription = "Welcome Illustration",
                        modifier = Modifier
                            .width(72.dp)
                            .height(72.dp)
                            .clip(RoundedCornerShape(16.dp))
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "Лицеист",
                        modifier = Modifier.padding(top = 16.dp),
                        fontFamily = robotoFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "г. Новосибирск, Лицей №28",
                    modifier = Modifier.padding(),
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Text(
                    text = "ул. Новая Заря, 27",
                    modifier = Modifier.padding(),
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(16.dp))
                ProfileTabRowCard()
                Spacer(modifier = Modifier.height(32.dp))
                ProfileCard(
                    onClick = onClick
                )
            }
        }
    }
}