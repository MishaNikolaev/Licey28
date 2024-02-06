package com.example.yourlicey28.domain.repository

import com.example.yourlicey28.domain.model.ImageDataDetails

interface RepositoryTask {
    suspend fun getImages():List<ImageDataDetails>
    suspend fun getImage(id:Int): ImageDataDetails
}