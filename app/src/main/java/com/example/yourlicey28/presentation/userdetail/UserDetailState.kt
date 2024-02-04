package com.example.yourlicey28.presentation.userdetail

import com.example.yourlicey28.domain.model.User
import com.example.yourlicey28.domain.model.UserDetails

data class UserDetailState(
    val userDetail: UserDetails = UserDetails(
        name = "",
        id = -1,
        status = "",
        gender = "",
        image = ""
    )
)