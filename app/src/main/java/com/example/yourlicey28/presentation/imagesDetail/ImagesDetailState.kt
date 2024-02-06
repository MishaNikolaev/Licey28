package com.example.yourlicey28.presentation.imagesDetail

import com.example.yourlicey28.domain.model.ImageDataDetails


data class ImagesDetailState (
    val imageDetail: ImageDataDetails = ImageDataDetails(
        author = "",
        id = -1,
        height = 2,
        width = 0,
        url = ""
    )
)