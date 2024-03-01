package com.example.yourlicey28.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.yourlicey28.data.remote.dto.RetrofitInstanceCar
import com.example.yourlicey28.data.repository.RepositoryImplCar
import com.example.yourlicey28.domain.repository.RepositoryCar
import com.example.yourlicey28.presentation.cars.CarScreen
import com.example.yourlicey28.presentation.cars.CarsViewModel
import com.example.yourlicey28.presentation.carsDetail.CarsDetailScreen
import com.example.yourlicey28.presentation.carsDetail.CarsDetailViewModel


@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screens.CarListScreen.route
    ) {

        composable(route = Screens.CarListScreen.route){
            val viewModel: CarsViewModel = hiltViewModel()

            CarScreen(
                state = viewModel.state.value,
                processEvent = viewModel::processEvent,
                onCarDetailScreenClick = {
                    navController.navigate(Screens.CarDetailsScreen.route + "?id=${it.id}")
                }
            )
        }
        composable(route = Screens.CarDetailsScreen.route + "?id={id}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType }
            )
        ) { navBackStackEntry ->
            val viewModel: CarsDetailViewModel = hiltViewModel()

            CarsDetailScreen(
                state = viewModel.state.value,
                processEvent = viewModel::processEvent,
            )

        }
    }
}


sealed class Screens(val route: String) {

    object CarListScreen: Screens("car_list_screen")

    object CarDetailsScreen: Screens("car_details_screen")
}