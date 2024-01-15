package com.example.yourlicey28.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.yourlicey28.presentation.home_with_bottom_navigation.HomeWithBottomNavigationScreen

@Composable
fun RootGraph(navController: NavHostController, startDestination: String) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = startDestination
    ) {
        welcomeGraph(navController = navController)
        composable(route = Graph.HOME) {
            HomeWithBottomNavigationScreen()
        }
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val WELCOME = "welcome_graph"
    const val HOME = "home_graph"
}