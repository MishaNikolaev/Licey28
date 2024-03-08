package com.example.yourlicey28.domain.repository

import com.example.yourlicey28.domain.model.CarDataDetails
import com.example.yourlicey28.util.Resource
import kotlinx.coroutines.flow.Flow

interface RepositoryCar {
    suspend fun getCars(): Flow<Resource<List<CarDataDetails>>>
    suspend fun getCar(id: Int): Flow<Resource<CarDataDetails>>
}