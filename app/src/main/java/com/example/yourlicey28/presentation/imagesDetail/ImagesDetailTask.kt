package com.example.yourlicey28.presentation.imagesDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UserDetailScreen(
    state: UserDetailState,
    processEvent: (UserDetailEvent) -> Unit
) {
    Column(modifier = Modifier.padding(top=20.dp,start=20.dp)) {
        Text(text = state.userDetail.name)
        Text(text = state.userDetail.id.toString())

    }
}