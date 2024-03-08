package com.example.yourlicey28.presentation.cars

import com.example.yourlicey28.domain.model.CarDataDetails

data class CarsState (
    val carsList: List<CarDataDetails> = listOf(),
    val isLoading:Boolean = false,
    val error:String = ""
)