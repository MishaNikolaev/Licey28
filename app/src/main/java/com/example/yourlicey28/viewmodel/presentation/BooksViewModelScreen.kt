package com.example.yourlicey28.viewmodel.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.yourlicey28.R
import com.example.yourlicey28.presentation.users.User
import com.example.yourlicey28.presentation.users.UsersEvent
import com.example.yourlicey28.presentation.users.UsersState
import com.example.yourlicey28.viewmodel.Book
import com.example.yourlicey28.viewmodel.BookEvent
import com.example.yourlicey28.viewmodel.BookState


@SuppressLint("UnrememberedMutableState")
@Composable
fun BooksScreen(
    state: BookState,
    processEvent: (BookEvent) -> Unit,
    onBooksDetailScreenClick: (book: Book) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        BookCard(
            books = state.bookList,
            processEvent = processEvent,
            onBooksDetailScreenClick = onBooksDetailScreenClick
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            FloatingActionButton(
                onClick = { processEvent(BookEvent.Add)}, modifier = Modifier.padding(16.dp), shape = CircleShape,
                containerColor = Color.Blue,
                contentColor = Color.White
            ) {
                Icon(Icons.Filled.Add, "Floating action button.")
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookCard(
    books: List<Book>,
    processEvent: (BookEvent) -> Unit,
    onBooksDetailScreenClick: (book: Book) -> Unit
) {
    LazyColumn {
        items(books) { book ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp)
                    .clickable { onBooksDetailScreenClick(book) }
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(R.drawable.bandicam_2024_01_22_18_06_43_475),
                        contentDescription = "Book Cover",
                        modifier = Modifier.size(180.dp)
                    )
                    Column {
                        var value by remember { mutableStateOf("") }
                        var isEditing by remember { mutableStateOf(false) }
                        var textValue by remember { mutableStateOf("Книга") }
                        var textValueInfo by remember { mutableStateOf("Описание") }

                        TextField(
                            value = textValue,
                            onValueChange = {
                                if (isEditing) {
                                    textValue = it
                                }
                            },
                            label = { Text("Название книги") },
                            enabled = isEditing,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        TextField(
                            value = textValueInfo,
                            onValueChange = {
                                if (isEditing) {
                                    textValueInfo = it
                                }
                            },
                            label = { Text("Краткое\nописание книги") },
                            enabled = isEditing,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Button(
                                onClick = {
                                    isEditing = !isEditing
                                },
                                modifier = Modifier
                                    .fillMaxWidth(0.5f)
                                    .padding(end = 10.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (isEditing) Color.Blue else Color.Green
                                )
                            ) {
                                Text(if (isEditing) "Сохранить" else "Изменить")
                            }

                            Button(
                                onClick = { processEvent(BookEvent.Remove(book = book)) },
                                modifier = Modifier.padding(end = 20.dp),
                                colors = ButtonDefaults.buttonColors(Color.Red)
                            ) {
                                Text(text = "Удалить")
                            }
                        }
                    }
                }
            }
        }
    }
}