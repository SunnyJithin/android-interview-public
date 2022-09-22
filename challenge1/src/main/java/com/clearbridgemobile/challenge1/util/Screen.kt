package com.clearbridgemobile.challenge1.util

sealed class Screen(val route: String) {
    object WelcomeScreen : Screen("welcome_screen")
    object HomeScreen : Screen("home_screen")
}
