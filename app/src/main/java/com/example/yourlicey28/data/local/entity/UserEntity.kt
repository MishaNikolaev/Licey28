package com.example.yourlicey28.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.yourlicey28.domain.model.User

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String
)

fun UserEntity.toUser(): User {
    return User(
        id = id,
        name = name
    )
}

