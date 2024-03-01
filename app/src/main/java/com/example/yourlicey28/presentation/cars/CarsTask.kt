package com.example.yourlicey28.presentation.cars

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.yourlicey28.domain.model.CarDataDetails

@SuppressLint("UnrememberedMutableState")
@Composable
fun CarScreen(
    state: CarsState,
    processEvent: (CarsEvent) -> Unit,
    onCarDetailScreenClick: (car: CarDataDetails) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        CarCard(
            cars = state.carsList,
            onCarDetailScreenClick = onCarDetailScreenClick
        )
    }
}

@Composable
fun CarCard(
    cars: List<CarDataDetails>,
    onCarDetailScreenClick: (cars: CarDataDetails) -> Unit
) {

    LazyColumn {
        items(cars){ car ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {
                        onCarDetailScreenClick(car)
                    }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(text = "id:${car.id}")
                    Text(text = "Mark: ${car.mark}")
                    Text(text = "Model: ${car.model}")
                    Text(text = "Description: ${car.description}")
                    Text(text = "Card Photo: ${car.cardPhoto}")
                }
            }
        }
    }
}



