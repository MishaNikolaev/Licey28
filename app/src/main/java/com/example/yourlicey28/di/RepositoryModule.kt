package com.example.yourlicey28.di

import com.example.yourlicey28.data.repository.RepositoryImplTask
import com.example.yourlicey28.domain.repository.RepositoryTask
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
        repositoryImplTask: RepositoryImplTask
    ): RepositoryTask

}