package com.example.yourlicey28.presentation.userdetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yourlicey28.domain.model.User
import com.example.yourlicey28.domain.model.UserDetails
import com.example.yourlicey28.domain.repository.Repository
import com.example.yourlicey28.presentation.users.UsersEvent
import com.example.yourlicey28.presentation.users.UsersState
import kotlinx.coroutines.launch

class UserDetailViewModel(private val repository: Repository) : ViewModel() {
    private val _state = mutableStateOf(UserDetailState())
    val state: State<UserDetailState> = _state

    fun processEvent(event: UserDetailEvent) {
        when (event) {
            is UserDetailEvent.GetUser -> getUser(id = event.id)
        }
    }


    private fun getUser(id: Int) {
        viewModelScope.launch {
            val userDetail = repository.getUser(id = id)
            _state.value = _state.value.copy(userDetail = userDetail)
        }
    }
}