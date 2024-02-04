package com.example.yourlicey28.presentation.users

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yourlicey28.domain.model.User
import com.example.yourlicey28.domain.repository.Repository
import kotlinx.coroutines.launch

class UsersViewModel(private val repository: Repository) : ViewModel() {
    private val _state = mutableStateOf(UsersState())
    val state: State<UsersState> = _state

    fun processEvent(event: UsersEvent) {
        when (event) {
            is UsersEvent.Add -> addUser()
            is UsersEvent.Remove -> removeUser(user = event.user)
        }
    }


    private fun addUser() {
        viewModelScope.launch {
            val users = repository.addUsers()
            _state.value = _state.value.copy(userList = users)
        }
    }

    private fun removeUser(user: User) {
        val newList = _state.value.userList.toMutableList()
        newList.remove(user)
        _state.value = _state.value.copy(userList = newList)
    }
}

private fun openUserDetails(user: User) {
    // Я не понимаю как сделать тут навигацию...
}
