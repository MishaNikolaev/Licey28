package com.example.yourlicey28.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.yourlicey28.presentation.user_detail.UserDetailViewModel
import com.example.yourlicey28.presentation.user_detail.UserDetailsScreen
import com.example.yourlicey28.presentation.users.UsersScreen
import com.example.yourlicey28.presentation.users.UsersViewModel

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screens.UserListScreen.route
    ) {
        composable(Screens.UserListScreen.route) {
            val viewModel: UsersViewModel = hiltViewModel()

            UsersScreen(
                state = viewModel.state.value,
                processEvent = viewModel::processEvent,
                onUserDetailScreenClick = {
                    navController.navigate(Screens.UserDetailsScreen.route + "?name=${it.name}&age=${it.age}")
                }
            )
        }

        composable(
            route = Screens.UserDetailsScreen.route + "?name={name}&age={age}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("age") { type = NavType.IntType }
            )
        ) { navBackStackEntry ->
            val viewModel: UserDetailViewModel = hiltViewModel()
            UserDetailsScreen(state = viewModel.state.value,
                processEvent = viewModel::processEvent)
        }
    }
}

sealed class Screens(val route: String) {
    object UserListScreen : Screens("user_list_screen")
    object UserDetailsScreen : Screens("user_details_screen")
}
