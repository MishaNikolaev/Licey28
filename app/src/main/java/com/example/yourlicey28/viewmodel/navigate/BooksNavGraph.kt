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
                    navController.navigate(BooksScreens.BookDetaisScreen.route + "?name=${it.name}&number=${it.number}")
                }
            )
        }

        composable(
            route = BooksScreens.BookDetaisScreen.route + "?name={name}&number={number}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("number") { type = NavType.IntType }
            )
        ) { navBackStackEntry ->
            val name = navBackStackEntry.arguments?.getString("name")
            val number = navBackStackEntry.arguments?.getInt("number")
            if (name != null && number != null) {
                BookDetailsScreen(
                    name = name,
                    age = number,
                    fullDescription = "Замысел эпопеи формировался задолго до начала работы над тем текстом, который известен под названием «Война и мир». В наброске предисловия к «Войне и миру» Толстой писал, что в 1856 году начал писать повесть, «герой которой должен был быть декабрист, возвращающийся с семейством в Россию. Невольно от настоящего я перешёл к 1825 году… Но и в 1825 году герой мой был уже возмужалым, семейным человеком. Чтобы понять его, мне нужно было перенестись к его молодости, и молодость его совпала с … эпохой 1812 года… Ежели причина нашего торжества была не случайна, но лежала в сущности характера русского народа и войска, то характер этот должен был выразиться ещё ярче в эпоху неудач и поражений…». Так Лев Николаевич постепенно пришёл к необходимости начать повествование с 1805 года. Главная тема — историческая судьба русского народа в Отечественной войне 1812 года. В романе выведено более 550 персонажей, как вымышленных, так и исторических. Лучших своих героев Л. Н. Толстой изображает во всей их душевной сложности, в непрерывных поисках истины, в стремлении к самосовершенствованию. Таковы князь Андрей, граф Николай, граф Пьер, графиня Наташа и княжна Марья. Отрицательные герои лишены развития, динамики, движений души: Элен, Анатоль."
                )
            }
        }
    }
}

sealed class BooksScreens(val route: String) {
    object BookListScreen : BooksScreens("book_list_screen")
    object BookDetaisScreen : BooksScreens("book_details_screen")
}
