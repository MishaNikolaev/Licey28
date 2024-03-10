package com.example.yourlicey28.presentation.images

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.yourlicey28.domain.model.User

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnrememberedMutableState")
@Composable
fun UsersScreen(
    state: UserState,
    processEvent: (UserEvent) -> Unit,
    onUserDetailScreenClick: (user: User) -> Unit
) {
    Scaffold(
        floatingActionButton = {
            IconButton(onClick = {
                processEvent(UserEvent.AddUser)
            }) {
                Text("+")
            }
        }
    ) { it->
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            UserCard(
                processEvent = processEvent,
                users = state.usersList,
                onUserDetailScreenClick = onUserDetailScreenClick
            )
        }
    }
}

@Composable
fun UserCard(
    users: List<User>,
    onUserDetailScreenClick: (user: User) -> Unit,
    processEvent: (UserEvent) -> Unit
) {

    LazyColumn {

        itemsIndexed(users) { index, item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {
                        onUserDetailScreenClick(item)
                    }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(text = "id:${item.id}")
                    Text(text = "Name: ${item.name}")

                    Row() {
                        Button(modifier = Modifier.background(Color.Blue),
                            onClick = { processEvent.invoke(UserEvent.UpdateUser(user = item)) }) {
                            Text(text = "Update")
                        }

                        Spacer(modifier = Modifier.width(20.dp))

                        Button(modifier = Modifier.background(Color.Red),
                            onClick = { processEvent.invoke(UserEvent.RemoveUser(user = item)) }) {
                            Text(text = "Delete")
                        }
                    }
                }


            }
        }
    }
}



