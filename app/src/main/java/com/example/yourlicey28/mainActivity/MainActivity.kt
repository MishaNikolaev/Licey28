package com.example.yourlicey28.mainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.yourlicey28.navgraph.BottomNav
import com.example.yourlicey28.navgraph.Graph
import com.example.yourlicey28.navgraph.MyNavHost
import com.example.yourlicey28.navgraph.RootGraph
import com.example.yourlicey28.navgraph.Screens


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            WindowCompat.setDecorFitsSystemWindows(window, false)
            val navController = rememberNavController()
            RootGraph(navController, startDestination = Graph.WELCOME)
        }
    }
}
