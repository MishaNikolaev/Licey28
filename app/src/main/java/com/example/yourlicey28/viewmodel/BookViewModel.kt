package com.example.yourlicey28.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.yourlicey28.presentation.users.User
import com.example.yourlicey28.presentation.users.UsersEvent
import com.example.yourlicey28.presentation.users.UsersState

private const val TAG = "BookViewModel"
class BookViewModel : ViewModel() {
    private val _state = mutableStateOf(BookState())
    val state: State<BookState> = _state

    fun processEvent(event: BookEvent) {
        when (event) {
            is BookEvent.Add -> addBook()
            is BookEvent.Remove -> removeBook(book = event.book)
            is BookEvent.Edit -> editBook(
                index = event.index,
                name = event.name,
                shortDescription = event.shortDescription
            )

            is BookEvent.Save -> removeBook(book = event.book)
        }
    }

    private fun addBook() {
        val name = "Книга${(1..1000).random()}"
        val shortDescription = "Описание ${(1..1000).random()}"
        val fullDescription =
            "$shortDescription еще что-то еще что-то еще что-то еще что-то еще что-то"
        val newBook = Book(
            name = name,
            shortDescription = shortDescription,
            fullDescription = fullDescription
        )
        val books = _state.value.bookList
        _state.value = _state.value.copy(bookList = books + newBook)
    }

    private fun removeBook(book: Book) {
        val bookList = _state.value.bookList.toMutableList()
        bookList.remove(book)
        _state.value = _state.value.copy(bookList = bookList)
        Log.d(TAG, "removeBook: $book")
        Log.d(TAG, "BookList: $bookList")
    }

    private fun editBook(index: Int, name: String, shortDescription: String) {
        val book =
            _state.value.bookList[index].copy(name = name, shortDescription = shortDescription)
        val bookList = _state.value.bookList.toMutableList()
        bookList[index] = book
        _state.value = _state.value.copy(bookList = bookList)
    }
}