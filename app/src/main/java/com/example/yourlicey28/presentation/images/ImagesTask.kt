package com.example.yourlicey28.presentation.images

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.yourlicey28.domain.model.ImageDataDetails

@SuppressLint("UnrememberedMutableState")
@Composable
fun ImageScreen(
    state: ImagesState,
    processEvent: (ImagesEvent) -> Unit,
    onImageDetailScreenClick: (image: ImageDataDetails) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        ImageCard(
            images = state.imagesList,
            onImageDetailScreenClick = onImageDetailScreenClick
        )
        IconButton(onClick = {
            processEvent(ImagesEvent.GetImages)
        }) {
            Icon(
                Icons.Filled.Add,
                contentDescription = "Информация о приложении", modifier = Modifier
                    .padding(top = 30.dp)
                    .size(120.dp),
                tint = Color.Black
            )
        }
    }
}

@Composable
fun ImageCard(
    images: List<ImageDataDetails>,
    onImageDetailScreenClick: (images: ImageDataDetails) -> Unit
) {

    LazyColumn {
        items(images){ image ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {
                        onImageDetailScreenClick(image)
                    }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(text = "id:${image.id}")
                    Text(text = "Name: ${image.author}")
                    Text(text = "url: ${image.url}")
                    Text(text = "height: ${image.height}")
                    Text(text = "width: ${image.width}")
                }
            }
        }
    }
}



