package com.example.metabotrack.navigation

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome_screen")
    object Login : Screen("login_screen")
    object Register : Screen("register_screen")
    object ActivityInput : Screen("activity_input_screen")
    object Summary : Screen("summary_screen")
}
