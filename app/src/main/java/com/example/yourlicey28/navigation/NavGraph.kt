package com.example.yourlicey28.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.yourlicey28.data.repository.RepositoryImpl
import com.example.yourlicey28.domain.repository.Repository
import com.example.yourlicey28.presentation.users.UsersScreen
import com.example.yourlicey28.presentation.users.UsersViewModel


val repositoryImpl = RepositoryImpl()

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screens.UserListScreen.route
    ) {
        composable(Screens.UserListScreen.route) {
            val viewModel: UsersViewModel =
                viewModel(factory = UserViewModelFactory(repositoryImpl))

            UsersScreen(
                state = viewModel.state.value,
                processEvent = viewModel::processEvent,
                onUserDetailScreenClick = {
                    navController.navigate(Screens.UserDetailsScreen.route + "?name=${it.name}")
                }
            )
        }
    }
}


class UserViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UsersViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UsersViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


sealed class Screens(val route: String) {
    object UserListScreen : Screens("user_list_screen")
    object UserDetailsScreen : Screens("user_details_screen")
}
