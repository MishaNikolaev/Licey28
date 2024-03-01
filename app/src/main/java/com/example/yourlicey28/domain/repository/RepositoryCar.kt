package com.example.yourlicey28.domain.repository

import com.example.yourlicey28.domain.model.CarDataDetails

interface RepositoryCar {
    suspend fun getCars():List<CarDataDetails>
    suspend fun getCar(id:Int): CarDataDetails
}