package com.example.yourlicey28.presentation.carsDetail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.yourlicey28.domain.model.CarDataDetails
import com.example.yourlicey28.presentation.cars.CarCard

@Composable
fun CarsDetailScreen(
    state: CarsDetailState,
    processEvent: (CarsDetailEvent) -> Unit
) {
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = state.carsDetail.model)
            Text(text = state.carsDetail.mark)
            Text(text = state.carsDetail.cardPhoto)

        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
        if (state.error!=""){
            Text(modifier = Modifier.align(Alignment.Center),text = "Ошибка: ${state.error}")
        }
    }
}