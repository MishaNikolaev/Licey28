package com.example.yourlicey28.presentation.example_viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class ExampleViewModel : ViewModel() {
    private val _state = mutableStateOf(ExampleViewModelState())
    val state: State<ExampleViewModelState> = _state

    init {
        onEvent(ExampleViewModelEvent.LoadUserList)
    }

    fun onEvent(event: ExampleViewModelEvent) {
        when (event) {
            is ExampleViewModelEvent.LoadUserList -> {
                // Загрузить список пользователей
                val user_1: User = User(name = "Usman")
                val user_2: User = User(name = "Mikhail")
                val users: List<User> = listOf(user_1, user_2)
                _state.value = _state.value.copy(users = users)
            }
        }
    }
}