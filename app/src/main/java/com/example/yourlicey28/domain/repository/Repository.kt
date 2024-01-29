package com.example.yourlicey28.domain.repository

import com.example.yourlicey28.domain.model.User

interface Repository {
    suspend fun addUsers():List<User>
}