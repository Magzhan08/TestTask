package com.example.testtask.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testtask.AnimatedSplashScreen
import com.example.testtask.TestScreen
import com.example.testtask.WebViewPage

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route){
            AnimatedSplashScreen(navController = navController)
        }
        composable(route = Screen.Web.route){
            val url = "https://www.google.com"
            WebViewPage(url = url)
        }
        composable(route = Screen.Test.route){
            TestScreen()
        }
    }
}