package com.cursosant.pantallalabo3.ui.navigation

sealed class Routes(val route: String){
    object Home: Routes("home")
    object Names: Routes("names")
    object Sensors: Routes("sensors")
}