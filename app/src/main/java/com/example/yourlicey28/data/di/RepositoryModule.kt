package com.example.yourlicey28.data.di

import com.example.yourlicey28.data.repository.RepositoryImplCar
import com.example.yourlicey28.domain.repository.RepositoryCar
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindRepository(
        repositoryImplCar: RepositoryImplCar
    ): RepositoryCar
}