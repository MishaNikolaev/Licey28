package com.example.yourlicey28.presentation.users

import com.example.yourlicey28.domain.model.User


data class UsersState(
    val userList: List<User> = listOf()
)