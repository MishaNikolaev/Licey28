package com.example.yourlicey28.presentation.users

sealed class UsersEvent {
    object Add : UsersEvent()
    data class Remove(val user: User) : UsersEvent()
}