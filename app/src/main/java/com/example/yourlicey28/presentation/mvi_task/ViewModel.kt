package com.example.yourlicey28.presentation.mvi_task

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {
    private val _state = mutableStateOf(UserListState(emptyList()))
    val state: State<UserListState> = _state

    fun processEvent(event: ViewModelListEvent) {
        when (event) {
            is ViewModelListEvent.AddViewModel -> addUser()
            is ViewModelListEvent.RemoveViewModel -> removeUser()
            is ViewModelListEvent.OpenViewModelDetails -> openUserDetails(event.user)
        }
    }

    private fun addUser() {
        val newUser = User("User${(1..100).random()}", (18..60).random())
        _state.value = _state.value.copy(userList = _state.value.userList + newUser)
    }

    private fun removeUser() {
        if (_state.value.userList.isNotEmpty()) {
            val newList = _state.value.userList.toMutableList()
            newList.removeAt(newList.size - 1)
            _state.value = _state.value.copy(userList = newList)
        }
    }

    private fun openUserDetails(user: User) {
        // Я не понимаю как сделать тут навигацию...
    }
}