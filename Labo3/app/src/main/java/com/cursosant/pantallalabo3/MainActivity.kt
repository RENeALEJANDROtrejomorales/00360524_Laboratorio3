package com.cursosant.pantallalabo3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.cursosant.pantallalabo3.ui.navigation.Routes
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cursosant.pantallalabo3.ui.screens.HomeScreen
import com.cursosant.pantallalabo3.ui.screens.NamesScreen
import com.cursosant.pantallalabo3.ui.screens.SensorScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavigation()
        }
    }
}


@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Home.route
    ) {

        composable(Routes.Home.route) {
            HomeScreen(navController)
        }

        composable(Routes.Names.route) {
            NamesScreen(navController)
        }

        composable(Routes.Sensors.route) {
            SensorScreen(navController)
        }
    }
}


