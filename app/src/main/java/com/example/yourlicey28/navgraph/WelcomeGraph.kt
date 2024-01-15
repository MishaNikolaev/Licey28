package com.example.yourlicey28.navgraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.yourlicey28.presentation.welcomeScreen.WelcomeScreen


fun NavGraphBuilder.welcomeGraph(
    navController: NavController
) {
    navigation(
        startDestination = WelcomeGraphScreen.WelcomeScreen.route,
        route = Graph.WELCOME
    ) {
        composable(route = WelcomeGraphScreen.WelcomeScreen.route) {
            WelcomeScreen(navController = navController)
        }
    }
}

sealed class WelcomeGraphScreen(val route: String) {
    object WelcomeScreen : WelcomeGraphScreen(route = "WelcomeScreen")
}