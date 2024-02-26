package com.example.yourlicey28.presentation.imagesDetail
sealed class UserDetailEvent {

    data class GetUser(val id: Int) : UserDetailEvent()

}