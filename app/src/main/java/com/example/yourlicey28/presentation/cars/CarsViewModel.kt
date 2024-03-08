package com.example.yourlicey28.presentation.cars

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yourlicey28.domain.repository.RepositoryCar
import com.example.yourlicey28.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
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
            val response = repository.getCars()
            response.collect{
                when (it){
                    is Resource.Success ->{
                        val cars = it.data!!
                        _state.value = _state.value.copy(carsList = cars)
                    }
                    is Resource.Loading->{
                        _state.value = _state.value.copy(isLoading = it.isLoading)
                    }
                    is Resource.Error->{
                        _state.value = _state.value.copy(error = it.message!!)
                    }
                }

            }


        }
    }
}