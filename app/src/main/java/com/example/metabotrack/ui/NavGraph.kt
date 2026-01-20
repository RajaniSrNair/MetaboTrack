package com.example.metabotrack.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.metabotrack.data.ui.ActivityInputScreen
import com.example.metabotrack.data.ui.SummaryScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") { WelcomeScreen(navController) }
        composable("input") { ActivityInputScreen(navController) }
        composable("summary") { SummaryScreen(navController) }
    }

}

