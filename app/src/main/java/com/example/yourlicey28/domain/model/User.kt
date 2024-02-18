package com.example.yourlicey28.domain.model

import com.example.yourlicey28.data.local.entity.UserEntity

data class User(
    val id: Int,
    val name:String
)

fun User.toUserEntity():UserEntity{
    return UserEntity(id = id,name = name)
}