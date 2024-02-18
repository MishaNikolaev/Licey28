package com.example.yourlicey28.domain.repository

import com.example.yourlicey28.domain.model.CarDataDetails
import com.example.yourlicey28.domain.model.ImageDataDetails

interface RepositoryCar {
    suspend fun getCars():List<CarDataDetails>
    suspend fun getCar(id:Int): CarDataDetails
}