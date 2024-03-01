package com.example.yourlicey28.presentation.cars

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yourlicey28.domain.repository.RepositoryCar
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class CarsViewModel @Inject constructor(private val repository: RepositoryCar) : ViewModel() {
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