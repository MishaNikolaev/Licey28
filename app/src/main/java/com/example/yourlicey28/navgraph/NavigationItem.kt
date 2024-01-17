package com.example.yourlicey28.navgraph

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.yourlicey28.R

sealed class Screens(val route: String, val imageVector: Int, val label: String) {

    object Home : Screens(
        route = NavCons.home,
        label = "Главная",
        imageVector = R.drawable.icon
    )

    object News : Screens(
        route = NavCons.news,
        label = "Новости",
        imageVector = R.drawable.icon
    )

    object Profile : Screens(
        route = NavCons.profile,
        label = "Профиль",
        imageVector = R.drawable.icon
    )
}

object NavCons {
    const val home = "Home"
    const val news = "News"
    const val profile = "Profile"
}