package com.example.yourlicey28.domain.repository

import com.example.yourlicey28.domain.model.User

interface RepositoryTask {
    suspend fun getUsers():List<User>

    suspend fun getUser(id:Int): User

    suspend fun insert(user:User)

    suspend fun update(user:User)

    suspend fun delete(user:User)
}