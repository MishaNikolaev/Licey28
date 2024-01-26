package com.example.yourlicey28.presentation.users

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.yourlicey28.R
import com.example.yourlicey28.domain.model.User

@SuppressLint("UnrememberedMutableState")
@Composable
fun UsersScreen(
    state: UsersState,
    processEvent: (UsersEvent) -> Unit,
    onUserDetailScreenClick: (user: User) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        UserCard(
            users = state.userList,
            processEvent = processEvent,
            onUserDetailScreenClick = onUserDetailScreenClick
        )
        IconButton(onClick = {
            processEvent(UsersEvent.Add)
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
fun UserCard(
    users: List<User>,
    processEvent: (UsersEvent) -> Unit,
    onUserDetailScreenClick: (user: User) -> Unit
) {
//    val usersViewModel: UsersViewModel = viewModel()
//    val navController = rememberNavController()

    LazyColumn {
        this.items(users) { user ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {
                        onUserDetailScreenClick(user)
                    }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = user.image),
                        contentDescription = "Welcome Illustration",
                        modifier = Modifier
                            .padding()
                            .width(50.dp)
                            .height(50.dp)
                    )
                    Text(text = "id:${user.id}")
                    Text(text = "Name: ${user.name}")
                    Text(text = "Gender: ${user.gender}")
//                    IconButton(onClick = {
//                        processEvent(UsersEvent.Remove(user = user))
//                    }) {
//                        Icon(imageVector = Icons.Default.Close, contentDescription = null)
//                    }
                }
            }
        }
    }
}




