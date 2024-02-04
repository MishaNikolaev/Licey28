package com.example.yourlicey28.presentation.userdetail

import androidx.compose.foundation.Image
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.example.yourlicey28.domain.model.User
import com.example.yourlicey28.presentation.users.UsersEvent
import com.example.yourlicey28.presentation.users.UsersState

@Composable
fun UserDetailScreen(
    state: UserDetailState,
    processEvent: (UserDetailEvent) -> Unit
) {

    Text(text = state.userDetail.name)
    Text(text = state.userDetail.gender)
    Text(text = state.userDetail.status)
    Text(text = state.userDetail.id.toString())
    AsyncImage(
        model = state.userDetail.image,
        contentDescription = "The delasign logo",
    )

}