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
import com.example.yourlicey28.util.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

private const val TAG = "RepositoryImplCar"

class RepositoryImplCar @Inject constructor(
    private val api: CarsApi,
    private val carsDao: CarsDao
) : RepositoryCar {
//    Делаем запрос по апи, получаем данные из апи
//    Добавляем полученные данные в бд
//    Возвращаем данные из бд

    override suspend fun getCars(): Flow<Resource<List<CarDataDetails>>> {
        return flow {
            emit(Resource.Loading(isLoading = true))
            delay(1500)
            try {
                val response = api.getCars(
                    skip = 0,
                    limit = 30,
                    authorization = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhZG1pbl8xNyIsImV4cCI6MTcxMjQxODgyNH0.tjVqCxBaeP5yJn01drhx0jgi5Fc6g7W1CcbfLp6oDr8"
                )
                val carsEntity = response.cars.map {
                    it.toCarEntity()
                }
                carsDao.insertAll(cars = carsEntity)
            } catch (e: Exception) {
                Log.d(TAG, "getCars: $e")
                emit(Resource.Error(message = "$e"))
            }
//        response.cars.forEach {
//            carsDao.insert(car = it.toCarEntity())
//        }
            val carsEntities = carsDao.getAll()

            val carsDetails = carsEntities.map {
                it.toCarDataDetails()
            }
            emit(Resource.Success(data = carsDetails))
            emit(Resource.Loading(isLoading = false))
        }
    }

    override suspend fun getCar(id: Int): Flow<Resource<CarDataDetails>> {
        return flow {
            emit(Resource.Loading(isLoading = true))
            delay(1500)
            try {
                val response = api.getCar(id = id)
                val carEntity = response.toCarEntity()
                carsDao.insert(car = carEntity)
            } catch (ex: Exception) {
                Log.d(TAG, "getCar: $ex")
                emit(Resource.Error(message = "$ex"))
            }

            val resultEntity = carsDao.getById(id = id)
            emit(Resource.Success(data = resultEntity.toCarDataDetails()))
            emit(Resource.Loading(isLoading = false))
        }
    }
}