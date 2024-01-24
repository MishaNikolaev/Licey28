package com.example.yourlicey28.mainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.yourlicey28.viewmodel.navigate.BooksNavGraph


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            WindowCompat.setDecorFitsSystemWindows(window, false)
            val navController = rememberNavController()
//            RootGraph(navController, startDestination = Graph.WELCOME)
//            NavGraph(navController = navController)
            BooksNavGraph(navController = navController)
        }
    }
}
