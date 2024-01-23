package com.example.yourlicey28.viewmodel

import com.example.yourlicey28.presentation.users.User

data class Book(
    val name: String,
    val number: Int,
)

data class Books(
    var shortDescription: String,
    val fullDescription: String
)

data class BookState(
    val bookList: List<Book> = listOf()
)