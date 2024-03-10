package com.example.yourlicey28.viewmodel.presentation

import android.util.Log
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.yourlicey28.R
import com.example.yourlicey28.viewmodel.Book
import com.example.yourlicey28.viewmodel.BookEvent
import com.example.yourlicey28.viewmodel.BookState

private const val TAG = "BooksViewModelScreen"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BooksScreen(
    state: BookState,
    processEvent: (BookEvent) -> Unit,
    onBooksDetailScreenClick: (book: Book) -> Unit
) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { processEvent(BookEvent.Add) },
                modifier = Modifier.padding(16.dp),
                shape = CircleShape,
                containerColor = Color.Blue,
                contentColor = Color.White
            ) {
                Icon(Icons.Filled.Add, "Floating action button.")
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp)
        ) {
            BookCard(
                books = state.bookList,
                processEvent = processEvent,
                onBooksDetailScreenClick = onBooksDetailScreenClick
            )
        }
    }
}

//        Column(
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Bottom,
//            horizontalAlignment = Alignment.End
//        ) {
//            FloatingActionButton(
//                onClick = { processEvent(BookEvent.Add)}, modifier = Modifier.padding(16.dp), shape = CircleShape,
//                containerColor = Color.Blue,
//                contentColor = Color.White
//            ) {
//                Icon(Icons.Filled.Add, "Floating action button.")
//            }
//        }
//
//    }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookCard(
    books: List<Book>,
    processEvent: (BookEvent) -> Unit,
    onBooksDetailScreenClick: (book: Book) -> Unit
) {
    LazyColumn {
        itemsIndexed(books, key = { _, book -> book.name }) { index, book ->
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
                        var isEditing by remember { mutableStateOf(false) }
                        var bookName by remember { mutableStateOf(book.name) }
                        var bookShortDescription by remember { mutableStateOf(book.shortDescription) }

                        Log.d(TAG, "BookCard: $isEditing\n$bookName\n$bookShortDescription")

                        TextField(
                            value = bookName,
                            onValueChange = {
                                if (isEditing) {
                                    bookName = it
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
                            value = bookShortDescription,
                            onValueChange = {
                                if (isEditing) {
                                    bookShortDescription = it
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
                                    if (!isEditing) {
                                        processEvent(
                                            BookEvent.Edit(
                                                index = index,
                                                name = bookName,
                                                shortDescription = bookShortDescription
                                            )
                                        )
                                    }
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

                            if (!isEditing) {
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
}