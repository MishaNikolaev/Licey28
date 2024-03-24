package com.example.yourlicey28.presentation.mvvm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MvvmViewModel @Inject constructor() : ViewModel() {
    private val _state = mutableStateOf("Hello, Jetpack Compose!")
    val state: State<String> = _state

    private val _state_loading = mutableStateOf(false)
    val state_loading: State<Boolean> = _state_loading

    fun updateMessage(newMessage: String) {
        _state.value = newMessage
    }

    fun updateLoading(){
        _state_loading.value = !state_loading.value
    }
}