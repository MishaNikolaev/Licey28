package com.example.yourlicey28.presentation.users

import com.example.yourlicey28.domain.model.User

sealed class UsersEvent {
    object Add : UsersEvent()
    data class Remove(val user: User) : UsersEvent()
}