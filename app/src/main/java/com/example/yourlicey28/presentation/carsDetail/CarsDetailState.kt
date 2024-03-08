package com.example.yourlicey28.presentation.carsDetail

import com.example.yourlicey28.domain.model.CarDataDetails

data class CarsDetailState (
    val carsDetail: CarDataDetails = CarDataDetails(
        mark = "",
        model = "",
        id = 2,
        description = "",
        cardPhoto = ""
    ),
    val isLoading:Boolean = false,
    val error:String = ""
)