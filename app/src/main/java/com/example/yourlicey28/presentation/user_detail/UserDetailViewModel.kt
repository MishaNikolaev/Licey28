package com.example.yourlicey28.presentation.user_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.yourlicey28.domain.model.User
import com.example.yourlicey28.presentation.users.UsersEvent
import com.example.yourlicey28.presentation.users.UsersState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(  private val savedStateHandle: SavedStateHandle) : ViewModel() {
    private val _state = mutableStateOf(UserDetailState())
    val state: State<UserDetailState> = _state

    init {
        val age = savedStateHandle.get<Int>("age")
        val name = savedStateHandle.get<String>("name")
        processEvent(event = UserDetailEvent.GetUser(age = age!!,name = name!!))
    }
    fun processEvent(event: UserDetailEvent) {
        when (event) {
            is UserDetailEvent.GetUser -> getUser(age =event.age,name = event.name)
        }
    }

    private fun getUser(age:Int,name:String) {
        val user: User = User(age = age,name = name)
        _state.value = _state.value.copy( user= user)
    }
}
