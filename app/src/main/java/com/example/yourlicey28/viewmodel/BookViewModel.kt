package com.example.yourlicey28.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.yourlicey28.presentation.users.User
import com.example.yourlicey28.presentation.users.UsersEvent
import com.example.yourlicey28.presentation.users.UsersState

class BookViewModel : ViewModel() {
    private val _state = mutableStateOf(BookState())
    val state: State<BookState> = _state

    fun processEvent(event: BookEvent) {
        when (event) {
            is BookEvent.Add -> addBook()
            is BookEvent.Remove -> removeBook(book = event.book)
            else -> {}
        }
    }

    private fun addBook() {
        val newBook = Book("Книга${(1..1000).random()}", (1..1000).random())
        val books = _state.value.bookList
        _state.value = _state.value.copy(bookList = books + newBook)
    }

    private fun removeBook(book: Book) {
        val bookList = _state.value.bookList.toMutableList()
        bookList.remove(book)
        _state.value = _state.value.copy(bookList = bookList)
    }
}