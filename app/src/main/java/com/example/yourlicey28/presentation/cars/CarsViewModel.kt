package com.example.yourlicey28.presentation.cars

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yourlicey28.domain.repository.RepositoryCar
import com.example.yourlicey28.domain.repository.RepositoryTask
import com.example.yourlicey28.presentation.images.ImagesEvent
import com.example.yourlicey28.presentation.images.ImagesState
import kotlinx.coroutines.launch

class CarsViewModel(private val repository: RepositoryCar) : ViewModel() {
    private val _state = mutableStateOf(CarsState())
    val state: State<CarsState> = _state

    init {
        processEvent(event = CarsEvent.getCars)
    }
    fun processEvent(event: CarsEvent) {
        when (event) {
            is CarsEvent.getCars -> getCars()
        }
    }


    private fun getCars() {
        viewModelScope.launch {
            val cars = repository.getCars()
            _state.value = _state.value.copy(carsList = cars)
        }
    }
}