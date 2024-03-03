package com.example.yourlicey28.data.di

import android.app.Application
import androidx.room.Room
import com.example.yourlicey28.data.local.AppDatabase
import com.example.yourlicey28.data.local.dao.CarsDao
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
    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "database-name.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideCarsDao(db:AppDatabase):CarsDao{
        return db.carsDao()
    }

}