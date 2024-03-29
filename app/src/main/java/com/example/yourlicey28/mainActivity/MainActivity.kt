package com.example.yourlicey28.mainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.example.yourlicey28.navgraph.BottomNav
import com.example.yourlicey28.navgraph.MyNavHost
import com.example.yourlicey28.navgraph.Screens


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WindowCompat.setDecorFitsSystemWindows(window, false)
            val navController = rememberNavController()
            Scaffold(
                bottomBar = {
                    BottomNav(navController = navController)
                }
            ) {
                it
                MyNavHost(
                    navHostController = navController,
                    startDestination = Screens.Home.route
                )
            }
        }
    }
}
