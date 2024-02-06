package com.example.yourlicey28.presentation.images

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yourlicey28.domain.repository.RepositoryTask
import kotlinx.coroutines.launch

class ImagesViewModel(private val repository: RepositoryTask) : ViewModel() {
    private val _state = mutableStateOf(ImagesState())
    val state: State<ImagesState> = _state

    fun processEvent(event: ImagesEvent) {
        when (event) {
            is ImagesEvent.GetImages -> getImages()
        }
    }


    private fun getImages() {
        viewModelScope.launch {
            val images = repository.getImages()
            _state.value = _state.value.copy(imagesList = images)
        }
    }
}