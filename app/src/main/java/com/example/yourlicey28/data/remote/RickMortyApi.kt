package com.example.yourlicey28.data.remote

import com.example.yourlicey28.data.remote.dto.RickMorty
import com.example.yourlicey28.domain.model.UserDetails
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickMortyApi {
    @GET("api/character/")
    suspend fun getCharachters(@Query("page") page: Int): RickMorty

    @GET("api/character/{id}")
    suspend fun getCharacter(@Path("id") id:Int): UserDetails
}

object RetrofitInstance {
    val api: RickMortyApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/") // Замените на ваш базовый URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickMortyApi::class.java)
    }
}