package com.example.testtask.navigation

sealed class Screen(val route: String){
    object Splash : Screen("splash_screen")
    object Web : Screen("web_screen")
    object Test : Screen("test_screen")
}
