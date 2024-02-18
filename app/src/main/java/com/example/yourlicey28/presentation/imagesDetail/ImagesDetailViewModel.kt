package com.example.yourlicey28.presentation.imagesDetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yourlicey28.domain.repository.RepositoryTask
import kotlinx.coroutines.launch

class ImagesDetailViewModel(private val repository: RepositoryTask) : ViewModel() {
    private val _state = mutableStateOf(ImagesDetailState())
    val state: State<ImagesDetailState> = _state

    fun processEvent(event: ImagesDetailEvent) {
        when (event) {
            is ImagesDetailEvent.GetImage -> getImage(id = event.id)
        }
    }


    private fun getImage(id: Int) {
        viewModelScope.launch {
            val imageDetail = repository.getImage(id = id)
            _state.value = _state.value.copy(imageDetail = imageDetail)
        }
    }
}