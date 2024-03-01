package com.example.yourlicey28.presentation.carsDetail

sealed class CarsDetailEvent {
    data class GetCar(val id: Int) : CarsDetailEvent()
}