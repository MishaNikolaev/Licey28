package com.example.yourlicey28.presentation.userdetail

import com.example.yourlicey28.domain.model.User

sealed class UserDetailEvent {
    data class GetUser(val id: Int) : UserDetailEvent()
}