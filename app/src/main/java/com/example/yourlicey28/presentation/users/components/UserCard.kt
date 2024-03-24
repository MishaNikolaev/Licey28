package com.example.yourlicey28.presentation.users.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.yourlicey28.R
import com.example.yourlicey28.domain.model.User
import com.example.yourlicey28.presentation.users.UsersEvent

@Composable
fun UserCard(
    users: List<User>,
    processEvent: (UsersEvent) -> Unit,
    onUserDetailScreenClick: (user: User) -> Unit
) {

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
                        painter = painterResource(id = R.drawable.person),
                        contentDescription = "Welcome Illustration",
                        modifier = Modifier
                            .padding()
                            .width(50.dp)
                            .height(50.dp)
                    )
                    Text(text = "Имя: ${user.name}")
                    Text(text = "Возраст: ${user.age}")
                    IconButton(onClick = {
                        processEvent(UsersEvent.Remove(user = user))
                    }) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = null)
                    }
                }
            }
        }
    }
}
