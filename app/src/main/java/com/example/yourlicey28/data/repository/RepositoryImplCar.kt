package com.example.yourlicey28.data.repository

import android.util.Log
import com.example.yourlicey28.data.local.AppDatabase
import com.example.yourlicey28.data.local.dao.CarsDao
import com.example.yourlicey28.data.local.entity.toCarDataDetails
import com.example.yourlicey28.data.remote.dto.CarsApi
import com.example.yourlicey28.data.remote.dto.toCarDataDetail
import com.example.yourlicey28.data.remote.dto.toCarEntity
import com.example.yourlicey28.domain.model.CarDataDetails
import com.example.yourlicey28.domain.repository.RepositoryCar
import javax.inject.Inject

private const val TAG = "RepositoryImplCar"
class RepositoryImplCar @Inject constructor(private val api: CarsApi, private val carsDao: CarsDao) : RepositoryCar {

    override suspend fun getCars(): List<CarDataDetails> {
        try{
            val response = api.getCars(skip = 0, limit = 30, authorization = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhZG1pbl8xNyIsImV4cCI6MTcwOTcxOTc5NX0.61JANV9HiSXq_XZFs5TSwMn8Sr2pcLoKr3BBlgfWttI")
            val carsEntity = response.cars.map {
                it.toCarEntity()
            }
            carsDao.insertAll(cars = carsEntity)
        }
        catch (e: Exception){
            Log.d(TAG, "getCars: $e")
        }
        val carsEntities = carsDao.getAll()

        val carsDetails = carsEntities.map {
            it.toCarDataDetails()
        }
        return carsDetails
    }

    override suspend fun getCar(id: Int): CarDataDetails {
        try {
            val response = api.getCar(id = id)
            val carEntity = response.toCarEntity()
            carsDao.insert(car = carEntity)
        }
        catch (ex: Exception){
            Log.d(TAG, "getCar: $ex")
        }
        val resultEntity = carsDao.getById(id = id)
        return resultEntity.toCarDataDetails()
    }
}