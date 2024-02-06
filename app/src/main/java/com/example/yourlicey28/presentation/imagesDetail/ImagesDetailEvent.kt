package com.example.yourlicey28.presentation.imagesDetail

import com.example.yourlicey28.presentation.userdetail.UserDetailEvent

sealed class ImagesDetailEvent {

    data class GetImage(val id: Int) : ImagesDetailEvent()
}