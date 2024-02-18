package com.example.yourlicey28.data.repository

import android.util.Log
import com.example.yourlicey28.data.remote.RickMortyApi
import com.example.yourlicey28.data.remote.dto.CarsApi
import com.example.yourlicey28.data.remote.dto.toCarDataDetail
import com.example.yourlicey28.data.remote.dto.toImageDataDetail
import com.example.yourlicey28.domain.model.CarDataDetails
import com.example.yourlicey28.domain.model.ImageDataDetails
import com.example.yourlicey28.domain.model.User
import com.example.yourlicey28.domain.model.UserDetails
import com.example.yourlicey28.domain.repository.Repository
import com.example.yourlicey28.domain.repository.RepositoryCar

private const val TAG = "RepositoryImplCar"
class RepositoryImplCar(private val api: CarsApi) : RepositoryCar {
    override suspend fun getCars(): List<CarDataDetails> {
        val response = api.getCars(skip = 0, limit = 30, authorization = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhZG1pbl8xNyIsImV4cCI6MTcwOTcxOTc5NX0.61JANV9HiSXq_XZFs5TSwMn8Sr2pcLoKr3BBlgfWttI")
        val carsList = mutableListOf<CarDataDetails>()
//        response.
        response.cars.forEach {
            carsList.add(
                it.toCarDataDetail()
            )
        }
        return carsList.toList()
    }

    override suspend fun getCar(id: Int): CarDataDetails {
        Log.d(TAG, "getCar: ${id}")
        val response = api.getCar(id = id)
        Log.d(TAG, "getCar: ${response}")
        return response.toCarDataDetail()
    }
}