package com.example.metabotrack


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.metabotrack.ui.WelcomeScreen
import com.example.metabotrack.ui.LoginScreen
import com.example.metabotrack.ui.HomeScreen
import com.example.metabotrack.ui.ActivityInputScreen
import com.example.metabotrack.ui.HistoryScreen
import com.example.metabotrack.ui.SummaryScreen
import com.example.metabotrack.ui.RegisterScreen
import com.example.metabotrack.navigation.Screen


import androidx.navigation.compose.rememberNavController
import com.example.metabotrack.ui.NavGraph
import com.google.firebase.ktx.Firebase
import com.google.firebase.analytics.ktx.analytics

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MetaboTrackApp()
        }
    }
}

@Composable
fun MetaboTrackApp() {
    val navController = rememberNavController()

    Surface(color = MaterialTheme.colorScheme.background) {
        NavHost(
            navController = navController,
            startDestination = Screen.Welcome.route
        ) {
            composable(Screen.Welcome.route) {
                WelcomeScreen(
                    onContinue = { navController.navigate(Screen.Login.route) }
                )
            }
            composable(Screen.Login.route) {
                LoginScreen(
                    onLoginSuccess = { navController.navigate(Screen.ActivityInput.route) }
                )
            }
            composable(Screen.Register.route) {
                RegisterScreen(
                    onRegisterSuccess = { navController.navigate(Screen.ActivityInput.route) }
                )
            }
            composable(Screen.ActivityInput.route) {
                ActivityInputScreen(
                    onViewSummary = { navController.navigate(Screen.Summary.route) }
                )
            }
            composable(Screen.Summary.route) {
                SummaryScreen()
            }
        }
    }
}