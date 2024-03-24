package com.example.yourlicey28.presentation.users

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.yourlicey28.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor() : ViewModel() {
    private val _state = mutableStateOf(UsersState())
    val state: State<UsersState> = _state

    fun processEvent(event: UsersEvent) {
        when (event) {
            is UsersEvent.Add -> addUser()
            is UsersEvent.Remove -> removeUser(user = event.user)
        }
    }

    private fun addUser() {
        val newUser = User("User${(1..100).random()}", (18..60).random())
        val users = _state.value.userList
        _state.value = _state.value.copy(userList = users + newUser)
    }

    private fun removeUser(user: User) {
        val newList = _state.value.userList.toMutableList()
        newList.remove(user)
        _state.value = _state.value.copy(userList = newList)
    }
}