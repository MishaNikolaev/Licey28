package com.example.yourlicey28.navgraph

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens(val route: String, val imageVector: ImageVector, val label: String) {

    object Home : Screens(
        route = NavCons.home,
        label = "Главная",
        imageVector = Icons.Rounded.Home
    )

    object News : Screens(
        route = NavCons.news,
        label = "Новости",
        imageVector = Icons.Rounded.DateRange
    )

    object Profile : Screens(
        route = NavCons.profile,
        label = "Профиль",
        imageVector = Icons.Rounded.Person
    )
}

object NavCons {
    const val home = "Home"
    const val news = "News"
    const val profile = "Profile"
}