package com.example.yourlicey28.viewmodel.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.yourlicey28.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BookDetailsScreen(name: String, age: Int,fullDescription:String ) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        androidx.compose.material3.Text(
            text = "Название: ${name}" +
                    "\nНомер: ${age}"
        )
        Image(
            painter = painterResource(id = R.drawable.bandicam_2024_01_22_18_06_43_475),
            contentDescription = "Welcome Illustration",
            modifier = Modifier
                .padding(top = 30.dp)
                .size(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Полное описание: ${fullDescription}")
    }
}

