package com.example.yourlicey28.presentation.images

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
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
            isLoading = state.isLoading,
            endIsReached = state.endIsReached,
            images = state.imagesList,
            onImageDetailScreenClick = onImageDetailScreenClick,
            processEvent = processEvent
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
    isLoading: Boolean,
    endIsReached: Boolean,
    images: List<ImageDataDetails>,
    onImageDetailScreenClick: (images: ImageDataDetails) -> Unit,
    processEvent: (ImagesEvent) -> Unit
) {

    LazyColumn {

        itemsIndexed(images) { index, image ->
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

            //    1)если индекс карточки равен последнему индекс imagesList (то есть мы находимся в конце списка ,
//    доскролили до конца списка) и endIsReached = False, то вызываем event на подгрузку данных (event.GetImages)
//    2)если isLoading true то показываем circularprogressindicator

            if (index == images.size - 1 && !endIsReached) {
                processEvent(ImagesEvent.GetImages)
            }

        }

        item {
            if (isLoading) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(text = "Pagination Loading")
                    CircularProgressIndicator(color = Color.Black)
                }
            }
        }

    }
}



