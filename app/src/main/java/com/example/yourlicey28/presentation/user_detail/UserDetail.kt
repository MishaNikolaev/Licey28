package com.example.yourlicey28.presentation.user_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.yourlicey28.R
import com.example.yourlicey28.presentation.users.UsersEvent

@Composable
fun UserDetailsScreen(
    state: UserDetailState,
    processEvent: (UserDetailEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Имя ${state.user.name} \nAge = ${state.user.age}")
    }
    Image(
        painter = painterResource(id = R.drawable.person),
        contentDescription = "Welcome Illustration",
        modifier = Modifier
            .padding()
            .width(50.dp)
            .height(50.dp)
    )
}