package com.example.yourlicey28.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.yourlicey28.presentation.homeScreen.HomeScreen
import com.example.yourlicey28.presentation.newsScreen.NewsScreen
import com.example.yourlicey28.presentation.profileScreen.ProfileScreen

@Composable
fun HomeGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = HomeGraphScreen.Home.route
    ) {
        composable(route = HomeGraphScreen.Home.route) {
            HomeScreen()
        }
        composable(route = HomeGraphScreen.News.route) {
            NewsScreen()
        }
        composable(route = HomeGraphScreen.Profile.route) {
            ProfileScreen()
        }
    }
}

sealed class HomeGraphScreen(val route: String) {
    object Home : HomeGraphScreen(route = "Home")
    object News : HomeGraphScreen(route = "News")
    object Profile : HomeGraphScreen(route = "Profile")
}