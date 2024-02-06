package com.example.yourlicey28.domain.repository

import com.example.yourlicey28.domain.model.User
import com.example.yourlicey28.domain.model.UserDetails

interface Repository {
    suspend fun addUsers():List<User>
    suspend fun getUser(id:Int):UserDetails
}