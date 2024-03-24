package com.example.yourlicey28.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.yourlicey28.presentation.mvi.MviScreen
import com.example.yourlicey28.presentation.mvi.MviViewModel
import com.example.yourlicey28.presentation.mvvm.MvvmScreen
import com.example.yourlicey28.presentation.mvvm.MvvmViewModel
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
        startDestination = MvvmScreen.Main.route
    ) {
        composable(MviScreen.Main.route){
            val viewModel: MviViewModel = hiltViewModel()

            MviScreen(
                state=viewModel.state.value
            )
        }

        composable(MvvmScreen.Main.route){
            val viewModel: MvvmViewModel = hiltViewModel()

            MvvmScreen(
                viewModel=viewModel,
                onClick = {
                    viewModel.updateMessage(newMessage = "UPDATED")
                }
            )
        }

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

sealed class MvvmScreen(val route: String) {
    object Main : MvvmScreen("main")
}

sealed class MviScreen(val route: String) {
    object Main : MviScreen("main_mvi")
}
