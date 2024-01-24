package com.example.yourlicey28.viewmodel

import com.example.yourlicey28.presentation.users.User

sealed class BookEvent {
    object Add : BookEvent()
    data class Remove(val book: Book) : BookEvent()
    data class Edit(val index: Int, val name: String, val shortDescription: String) : BookEvent()
    data class Save(val book: Book) : BookEvent()
}