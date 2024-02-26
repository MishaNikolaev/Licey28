package com.example.yourlicey28.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.room.Room
import com.example.yourlicey28.data.local.AppDatabase
import com.example.yourlicey28.data.repository.RepositoryImplTask
import com.example.yourlicey28.domain.repository.RepositoryTask
import com.example.yourlicey28.presentation.images.UsersScreen
import com.example.yourlicey28.presentation.images.UsersViewModel
import com.example.yourlicey28.presentation.imagesDetail.UserDetailEvent
import com.example.yourlicey28.presentation.imagesDetail.UserDetailScreen
import com.example.yourlicey28.presentation.imagesDetail.UserDetailViewModel
import kotlinx.coroutines.launch


@Composable
fun NavGraph(
    navController: NavHostController,
    db: AppDatabase
) {
    val repositoryImpl = RepositoryImplTask(db = db)

    NavHost(
        navController = navController,
        startDestination = Screens.UsersScreen.route
    ) {

        composable(route = Screens.UsersScreen.route) {
            val viewModel: UsersViewModel =
                viewModel(factory = UsersViewModelFactory(repositoryImpl))

            UsersScreen(
                state = viewModel.state.value,
                processEvent = viewModel::processEvent,
                onUserDetailScreenClick = {
                    navController.navigate(Screens.UserDetailScreen.route + "?id=${it.id}")
                }
            )
        }
        composable(route = Screens.UserDetailScreen.route + "?id={id}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType }
            )) { navBackStackEntry ->
            val viewModel: UserDetailViewModel =
                viewModel(factory = UsersDetailViewModelFactory(repositoryImpl))
            val id = navBackStackEntry.arguments?.getInt("id")
            if (id != null) {
                viewModel.processEvent(event = UserDetailEvent.GetUser(id = id))

                UserDetailScreen(
                    state = viewModel.state.value,
                    processEvent = viewModel::processEvent,
                )
            }
        }

    }
}


sealed class Screens(val route: String) {
    object UsersScreen : Screens("users_screen")
    object UserDetailScreen : Screens("users_detail_screen")

}


class UsersViewModelFactory(private val repository: RepositoryTask) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UsersViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UsersViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

class UsersDetailViewModelFactory(private val repository: RepositoryTask) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserDetailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


