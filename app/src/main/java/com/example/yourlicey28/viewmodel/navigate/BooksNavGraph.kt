package com.example.yourlicey28.viewmodel.navigate

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.yourlicey28.presentation.user_detail.UserDetailsScreen
import com.example.yourlicey28.presentation.users.UsersScreen
import com.example.yourlicey28.presentation.users.UsersViewModel
import com.example.yourlicey28.viewmodel.BookViewModel
import com.example.yourlicey28.viewmodel.presentation.BookDetailsScreen
import com.example.yourlicey28.viewmodel.presentation.BooksScreen


@Composable
fun BooksNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BooksScreens.BookListScreen.route
    ) {
        composable(BooksScreens.BookListScreen.route) {
            val viewModel: BookViewModel = viewModel()

            BooksScreen(
                state = viewModel.state.value,
                processEvent = viewModel::processEvent,
                onBooksDetailScreenClick = {
                    navController.navigate(BooksScreens.BookDetaisScreen.route + "?name=${it.name}&shortDescription=${it.shortDescription}&fullDescription=${it.fullDescription}")
                }
            )
        }

        composable(
            route = BooksScreens.BookDetaisScreen.route + "?name={name}&shortDescription={shortDescription}&fullDescription={fullDescription}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("shortDescription") { type = NavType.StringType },
                navArgument("fullDescription") { type = NavType.StringType }
            )
        ) { navBackStackEntry ->
            val name = navBackStackEntry.arguments?.getString("name")
            val shortDescription = navBackStackEntry.arguments?.getString("shortDescription")
            val fullDescription = navBackStackEntry.arguments?.getString("fullDescription")
            if (name != null && shortDescription != null && fullDescription != null) {
                BookDetailsScreen(
                    name = name,
                    shortDescription = shortDescription,
                    fullDescription = fullDescription
                )
            }
        }
    }
}

sealed class BooksScreens(val route: String) {
    object BookListScreen : BooksScreens("book_list_screen")
    object BookDetaisScreen : BooksScreens("book_details_screen")
}
