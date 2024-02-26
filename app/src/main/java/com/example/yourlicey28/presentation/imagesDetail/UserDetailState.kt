package com.example.yourlicey28.presentation.imagesDetail

import com.example.yourlicey28.domain.model.User

data class UserDetailState (
    val userDetail: User = User(
        name = "",
        id = -1
   )
)