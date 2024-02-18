package com.example.yourlicey28.presentation.carsDetail

import com.example.yourlicey28.presentation.imagesDetail.ImagesDetailEvent

sealed class CarsDetailEvent {
    data class GetCar(val id: Int) : CarsDetailEvent()
}