package com.example.yourlicey28.data.remote.dto

import com.example.yourlicey28.domain.model.ImageDataDetails


data class ImageDataDetailsDto(
    val author: String,
    val url: String,
    val id: Int,
    val width: Int,
    val height: Int
)

fun ImageDataDetailsDto.toImageDataDetail(): ImageDataDetails {
    return ImageDataDetails(id = id, author = author, url = url, width = width, height = height)
}