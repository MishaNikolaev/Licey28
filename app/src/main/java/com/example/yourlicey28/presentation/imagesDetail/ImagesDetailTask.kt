package com.example.yourlicey28.presentation.imagesDetail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import coil.compose.AsyncImage
import com.example.yourlicey28.presentation.userdetail.UserDetailEvent
import com.example.yourlicey28.presentation.userdetail.UserDetailState

@Composable
fun ImageDetailScreen(
    state: ImagesDetailState,
    processEvent: (ImagesDetailEvent) -> Unit
) {

    Text(text = state.imageDetail.author)
    Text(text = state.imageDetail.url)

}