package com.example.yourlicey28.presentation.mvi_task

data class User(
    val name: String,
    val age: Int
)
data class UserListState(val userList: List<User>)