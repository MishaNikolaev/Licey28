package com.example.yourlicey28.presentation.mvi

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun MviScreen(state: MviState) {
    Text(text = state.message)
}