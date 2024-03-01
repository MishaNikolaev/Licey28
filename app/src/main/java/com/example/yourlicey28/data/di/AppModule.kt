package com.example.yourlicey28.data.di

import android.app.Application
import com.example.yourlicey28.data.remote.dto.CarsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(app: Application): CarsApi {
        return Retrofit.Builder()
            .baseUrl("https://bipbip.uz/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create()
    }
}