package com.example.yourlicey28.data.remote.dto

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface CarsApi {
    @GET("api/cars/all")
    suspend fun getCars(
        @Header("Authorization") authorization: String, //Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhZG1pbl8xNyIsImV4cCI6MTcwOTcxOTc5NX0.61JANV9HiSXq_XZFs5TSwMn8Sr2pcLoKr3BBlgfWttI
        @Query("skip") skip: Int,
        @Query("limit") limit: Int
    ): CarsAllDto

    //cars : List<Cars>

    @GET("api/cars/get_by_id")
    suspend fun getCar(
        @Query("id") id: Int
    ): CarsDataDetailsDto
}

object RetrofitInstanceCar {
    val api: CarsApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://bipbip.uz/")
            // Замените на ваш базовый URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CarsApi::class.java)
    }
}