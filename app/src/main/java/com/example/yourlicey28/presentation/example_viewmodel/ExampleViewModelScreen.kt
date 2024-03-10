package com.example.yourlicey28.presentation.example_viewmodel

import android.util.Log
import androidx.compose.runtime.Composable

private const val TAG = "ExampleViewModelScreen"
@Composable
fun ExampleViewModelScreen(viewModel: ExampleViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val state = viewModel.state.value

    if (state.isLoading) {
        // Отображение индикатора загрузки
    } else if (state.error.isNotEmpty()) {
        // Отображение ошибки
    } else {
        Log.d(TAG, "ExampleViewModelScreen: ${state.users}")
    }
}