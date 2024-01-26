package com.example.yourlicey28.domain.repository

import com.example.yourlicey28.domain.model.User

interface Repository {
    fun addUsers():List<User>
}