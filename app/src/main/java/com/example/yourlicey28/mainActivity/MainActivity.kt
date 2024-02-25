package com.example.yourlicey28.mainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.yourlicey28.data.local.AppDatabase
import com.example.yourlicey28.navigation.NavGraph


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "database-name"
            ).build()
            val navController = rememberNavController()
            NavGraph(navController = navController, db = db)
        }
    }
}
