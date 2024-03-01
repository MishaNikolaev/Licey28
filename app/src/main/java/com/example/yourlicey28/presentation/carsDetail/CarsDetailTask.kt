package com.example.yourlicey28.presentation.carsDetail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun CarsDetailScreen(
    state: CarsDetailState,
    processEvent: (CarsDetailEvent) -> Unit
) {

    Text(text = state.carsDetail.model)
    Text(text = state.carsDetail.mark)
    Text(text = state.carsDetail.cardPhoto)

}