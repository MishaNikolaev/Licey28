package com.example.yourlicey28.presentation.images

import com.example.yourlicey28.domain.model.ImageDataDetails

data class ImagesState (
    val imagesList: List<ImageDataDetails> = listOf(),
    val page : Int = 1,
    val endIsReached: Boolean = false,
    val isLoading: Boolean = false
)