package com.example.yourlicey28.presentation.mvi_task

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
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.yourlicey28.R
import com.example.yourlicey28.navgraph.Graph

@SuppressLint("UnrememberedMutableState")
@Composable
fun ViewModelListScreen(viewModel: ViewModel) {
    val state = viewModel.state.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        UserList(users = state.userList) {
            viewModel.processEvent(ViewModelListEvent.OpenViewModelDetails(it))
        }
        IconButton(onClick = { viewModel.processEvent(ViewModelListEvent.AddViewModel) }) {
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
fun UserList(users: List<User>, onClick: (User) -> Unit) {
    val viewModel: ViewModel = viewModel()
    val navController = rememberNavController()
    LazyColumn {
        this.items(users) { user ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { navController.navigate(Screens.UserDetailsScreen.route) }
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
                    IconButton(onClick = { viewModel.processEvent(ViewModelListEvent.RemoveViewModel) }) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = null)
                    }
                }
            }
        }
    }
}

@Composable
fun UserDetailsScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Имя")
    }
    Image(
        painter = painterResource(id = R.drawable.person),
        contentDescription = "Welcome Illustration",
        modifier = Modifier
            .padding()
            .width(50.dp)
            .height(50.dp)
    )
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val userListViewModel: ViewModel = viewModel()
    ViewModelListScreen(userListViewModel)
}

sealed class Screens(val route: String) {
    object UserListScreen : Screens("user_list_screen")
    object UserDetailsScreen : Screens("user_details_screen")
}

/*@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screens.UserListScreen.route
    ) {
        composable(Screens.UserDetailsScreen.route) {
            UserList(onClick = {
                navController.navigate(route=Screens.UserDetailsScreen.route)
            })
        }
    }
}*/