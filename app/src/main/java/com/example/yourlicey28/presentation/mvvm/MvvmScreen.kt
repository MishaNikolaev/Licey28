package com.example.yourlicey28.presentation.mvvm

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun MvvmScreen(viewModel: MvvmViewModel,onClick:()->Unit) {
    val message = viewModel.state.value
    val isloading = viewModel.state_loading.value
    Text(text = message)
    Text(text = isloading.toString())

    Button(onClick = onClick) {

    }
}