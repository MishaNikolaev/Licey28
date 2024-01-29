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
import com.example.yourlicey28.navgraph.RootGraph
import com.example.yourlicey28.navgraph.Screens
import com.example.yourlicey28.presentation.homeScreen.licey28Info.Licey28Info
import com.example.yourlicey28.presentation.homeScreen.nabor1class.NaborFirstClass
import com.example.yourlicey28.presentation.profileScreen.lessons.LessonsKruzhki
import com.example.yourlicey28.presentation.profileScreen.ntoSchool.NtoSchool
import com.example.yourlicey28.presentation.profileScreen.timeTableZvonkov.TimeTableZvokov
import com.example.yourlicey28.presentation.profileScreen.upgradeApp.UpgradeApp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            WindowCompat.setDecorFitsSystemWindows(window, false)
            val navController = rememberNavController()
            //RootGraph(navController, startDestination = Graph.WELCOME)

            NaborFirstClass()
        }
    }
}
