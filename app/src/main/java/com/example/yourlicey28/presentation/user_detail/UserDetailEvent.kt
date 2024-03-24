package com.example.yourlicey28.presentation.user_detail

sealed class UserDetailEvent {
    data class GetUser(val name:String,val age:Int): UserDetailEvent()
}