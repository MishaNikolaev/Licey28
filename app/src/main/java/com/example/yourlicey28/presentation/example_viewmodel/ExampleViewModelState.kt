package com.example.yourlicey28.presentation.example_viewmodel
data class ExampleViewModelState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    val error: String = ""
)

data class User(val name: String)
