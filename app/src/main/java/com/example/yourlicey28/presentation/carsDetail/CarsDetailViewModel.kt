package com.example.yourlicey28.presentation.carsDetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yourlicey28.domain.repository.RepositoryCar
import com.example.yourlicey28.domain.repository.RepositoryTask
import com.example.yourlicey28.presentation.imagesDetail.ImagesDetailEvent
import com.example.yourlicey28.presentation.imagesDetail.ImagesDetailState
import kotlinx.coroutines.launch

class CarsDetailViewModel(
    private val repository: RepositoryCar,
    private val savedStateHandle: SavedStateHandle
    ) : ViewModel() {
    private val _state = mutableStateOf(CarsDetailState())
    val state: State<CarsDetailState> = _state

    init{
        val id = savedStateHandle.get<Int>("id")
        processEvent(event = CarsDetailEvent.GetCar(id = id!!))
    }
    fun processEvent(event: CarsDetailEvent) {
        when (event) {
            is CarsDetailEvent.GetCar -> getCar(id = event.id)
        }
    }


    private fun getCar(id: Int) {
        viewModelScope.launch {
            val carDetail = repository.getCar(id = id)
            _state.value = _state.value.copy(carsDetail = carDetail)
        }
    }
}