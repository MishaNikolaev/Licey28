package com.example.yourlicey28.presentation.mvi_task

sealed class ViewModelListEvent {
    object AddViewModel : ViewModelListEvent()
    object RemoveViewModel : ViewModelListEvent()
    data class OpenViewModelDetails(val user: User) : ViewModelListEvent()
}