package com.example.yourlicey28.data.remote

import com.example.yourlicey28.data.remote.dto.ImageDataDetailsDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ImagesApi {

    @GET("v2/list")
    suspend fun getImages(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): List<ImageDataDetailsDto>

    @GET("/id/{id}/info")
    suspend fun getImage(
        @Path("id") id: Int
    ): ImageDataDetailsDto

//    @GET("api/cars/all")
//    suspend fun getCars(
//        @Header("Authorization") authorization: String, //Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhZG1pbl8xNyIsImV4cCI6MTcwOTcxOTc5NX0.61JANV9HiSXq_XZFs5TSwMn8Sr2pcLoKr3BBlgfWttI
//        @Query("skip") skip: Int,
//        @Query("limit") limit: Int
//    ): ...
}

object RetrofitImageInstance {
    val api: ImagesApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://picsum.photos/") // Замените на ваш базовый URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ImagesApi::class.java)
    }
}