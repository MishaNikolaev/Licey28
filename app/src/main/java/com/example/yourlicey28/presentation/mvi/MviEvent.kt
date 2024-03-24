package com.example.yourlicey28.presentation.mvi

sealed class MviEvent {
    object LoadMessage : MviEvent()
    data class UpdateMessage(val newMessage: String) : MviEvent()
}