package com.example.yourlicey28.navgraph

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.yourlicey28.presentation.homeScreen.HomeScreen
import com.example.yourlicey28.presentation.newsScreen.NewsScreen
import com.example.yourlicey28.presentation.profileScreen.ProfileScreen
import com.example.yourlicey28.presentation.profileScreen.lessons.LessonsKruzhki

private const val TAG = "HomeGraph"
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
            NewsScreen(onClick = {
                navController.navigate(ProfileGraphScreen.LessonsKruzkiScreen.route)
            })
        }
        composable(route = HomeGraphScreen.Profile.route) {
            ProfileScreen(onClick = {
                Log.d(TAG, "HomeGraph: CLICKED")
                navController.navigate(ProfileGraphScreen.LessonsKruzkiScreen.route)
            })
        }
        composable(route = ProfileGraphScreen.LessonsKruzkiScreen.route) {
            LessonsKruzhki()
        }

    }
}

sealed class HomeGraphScreen(val route: String) {
    object Home : HomeGraphScreen(route = "Home")
    object News : HomeGraphScreen(route = "News")
    object Profile : HomeGraphScreen(route = "Profile")
}

sealed class ProfileGraphScreen(val route: String) {
    object LessonsKruzkiScreen : ProfileGraphScreen(route = "LessonsKruzkiScreen")
}
