package com.example.yourlicey28.presentation.mvi

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.yourlicey28.domain.model.User
import com.example.yourlicey28.presentation.user_detail.UserDetailEvent
import com.example.yourlicey28.presentation.user_detail.UserDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MviViewModel @Inject constructor(): ViewModel(){

    private val _state = mutableStateOf(MviState())
    val state: State<MviState> = _state

    init {
        processEvent(event = MviEvent.LoadMessage)
    }
    fun processEvent(event: MviEvent) {
        when (event) {
            is MviEvent.LoadMessage -> loadMessage()
            is MviEvent.UpdateMessage -> {}
        }
    }

    private fun loadMessage() {
        _state.value = _state.value.copy( message = "HELLO")
    }
}