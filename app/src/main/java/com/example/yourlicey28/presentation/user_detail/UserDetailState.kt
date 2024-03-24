package com.example.yourlicey28.presentation.user_detail

import com.example.yourlicey28.domain.model.User

data class UserDetailState(

    val user: User = User(name = "", age = -1)
)