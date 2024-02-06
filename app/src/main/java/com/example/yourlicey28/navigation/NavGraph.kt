package com.example.yourlicey28.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.yourlicey28.data.remote.RetrofitInstance
import com.example.yourlicey28.data.remote.dto.RetrofitImageInstance
import com.example.yourlicey28.data.repository.RepositoryImpl
import com.example.yourlicey28.data.repository.RepositoryImplTask
import com.example.yourlicey28.domain.repository.Repository
import com.example.yourlicey28.domain.repository.RepositoryTask
import com.example.yourlicey28.presentation.images.ImageScreen
import com.example.yourlicey28.presentation.images.ImagesViewModel
import com.example.yourlicey28.presentation.imagesDetail.ImageDetailScreen
import com.example.yourlicey28.presentation.imagesDetail.ImagesDetailEvent
import com.example.yourlicey28.presentation.imagesDetail.ImagesDetailViewModel
import com.example.yourlicey28.presentation.userdetail.UserDetailEvent
import com.example.yourlicey28.presentation.userdetail.UserDetailScreen
import com.example.yourlicey28.presentation.userdetail.UserDetailViewModel
import com.example.yourlicey28.presentation.users.UsersScreen
import com.example.yourlicey28.presentation.users.UsersViewModel


val repositoryImpl = RepositoryImpl(RetrofitInstance.api)
val repositoryImplTask = RepositoryImplTask(RetrofitImageInstance.api)

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screens.ImageListScreen.route
    ) {
        composable(Screens.UserListScreen.route) {
            val viewModel: UsersViewModel =
                viewModel(factory = UserViewModelFactory(repositoryImpl))

            UsersScreen(
                state = viewModel.state.value,
                processEvent = viewModel::processEvent,
                onUserDetailScreenClick = {
                    navController.navigate(Screens.UserDetailsScreen.route + "?id=${it.id}")
                }
            )
        }

        composable(route = Screens.UserDetailsScreen.route + "?id={id}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType }
            )
        ) { navBackStackEntry ->
            val viewModel: UserDetailViewModel =
                viewModel(factory = UserDetailViewModelFactory(repositoryImpl))

            val id = navBackStackEntry.arguments?.getInt("id")
            if (id != null) {
                viewModel.processEvent(event = UserDetailEvent.GetUser(id = id))

                UserDetailScreen(
                    state = viewModel.state.value,
                    processEvent = viewModel::processEvent,
                )
            }

        }

        composable(route = Screens.ImageListScreen.route){
            val viewModel: ImagesViewModel =
                viewModel(factory = ImagesViewModelFactory(repositoryImplTask))

            ImageScreen(
                state = viewModel.state.value,
                processEvent = viewModel::processEvent,
                onImageDetailScreenClick = {
                    navController.navigate(Screens.ImageDetailsScreen.route + "?id=${it.id}")
                }
            )
        }
        composable(route = Screens.ImageDetailsScreen.route + "?id={id}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType }
            )
        ) { navBackStackEntry ->
            val viewModel: ImagesDetailViewModel =
                viewModel(factory = ImageDetailViewModelFactory(repositoryImplTask))

            val id = navBackStackEntry.arguments?.getInt("id")
            if (id != null) {
                viewModel.processEvent(event = ImagesDetailEvent.GetImage(id=id))

                ImageDetailScreen(
                    state = viewModel.state.value,
                    processEvent = viewModel::processEvent,
                )
            }

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

class UserDetailViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserDetailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


sealed class Screens(val route: String) {
    object UserListScreen : Screens("user_list_screen")
    object UserDetailsScreen : Screens("user_details_screen")

    object ImageListScreen: Screens("image_list_screen")

    object ImageDetailsScreen: Screens("image_details_screen")
}


class ImageDetailViewModelFactory(private val repository: RepositoryTask) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ImagesDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ImagesDetailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

class ImagesViewModelFactory(private val repository: RepositoryTask) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ImagesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ImagesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}