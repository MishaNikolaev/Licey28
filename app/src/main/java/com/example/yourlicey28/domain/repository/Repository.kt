package com.example.yourlicey28.domain.repository

import com.example.yourlicey28.domain.model.User
import com.example.yourlicey28.domain.model.UserDetails
import com.example.yourlicey28.domain.model_image.ImageData
import com.example.yourlicey28.domain.model_image.ImageDataDetails

interface Repository {
    suspend fun addUsers():List<User>

    suspend fun getUser(id:Int):UserDetails

    suspend fun addImages():List<ImageData>

    suspend fun getImages(id:Int):ImageDataDetails
}