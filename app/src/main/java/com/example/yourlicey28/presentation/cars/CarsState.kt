package com.example.yourlicey28.presentation.cars

import com.example.yourlicey28.data.remote.dto.CarsDataDetailsDto
import com.example.yourlicey28.domain.model.CarDataDetails
import com.example.yourlicey28.domain.model.ImageDataDetails

data class CarsState (
    val carsList: List<CarDataDetails> = listOf()
)