package com.example.yourlicey28.presentation.users

data class User(
    val name: String,
    val age: Int
)
data class UsersState(
    val userList: List<User> = listOf()
)