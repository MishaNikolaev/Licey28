package com.example.yourlicey28.presentation.images

import com.example.yourlicey28.domain.model.User

sealed class UserEvent {

    object AddUser : UserEvent()

    data class RemoveUser(val user:User) : UserEvent()

    data class UpdateUser(val user:User) : UserEvent()

    object GetUsers : UserEvent()
}