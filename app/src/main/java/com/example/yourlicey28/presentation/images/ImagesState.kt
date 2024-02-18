package com.example.yourlicey28.presentation.images

data class ImagesState (
    val imagesList: List<ImageDataDetails> = listOf(),
    val page : Int = 1,
    val endIsReached: Boolean = false,
    val isLoading: Boolean = false
)