package com.example.yourlicey28.viewmodel

data class BookState(
    val bookList: List<Book> = listOf()
)

data class Book(
    val name: String,
    val shortDescription: String,
    val fullDescription: String
)

